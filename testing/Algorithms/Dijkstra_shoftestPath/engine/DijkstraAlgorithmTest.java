package Algorithms.Dijkstra_shoftestPath.engine;

import Algorithms.Dijkstra_shoftestPath.model.Edge;
import Algorithms.Dijkstra_shoftestPath.model.Graph;
import Algorithms.Dijkstra_shoftestPath.model.Vertex;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by Sebastian Börebäck on 2016-01-21.
 */
public class DijkstraAlgorithmTest {


	List<Vertex> nodes;
	List<Edge> edges;

	@Test
	public void testExecute() throws Exception {

		//Setup
		// Generate nodes
		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		for (int i = 0; i < 11; i++) {
			Vertex location = new Vertex("Node_" + i, "Node_" + i);
			nodes.add(location);
		}

		addLane("Edge_0", 0, 1, 85);
		addLane("Edge_1", 0, 2, 217);
		addLane("Edge_2", 0, 4, 173);
		addLane("Edge_3", 2, 6, 186);
		addLane("Edge_4", 2, 7, 103);
		addLane("Edge_5", 3, 7, 183);
		addLane("Edge_6", 5, 8, 250);
		addLane("Edge_7", 8, 9, 84);
		addLane("Edge_8", 7, 9, 167);
		addLane("Edge_9", 4, 9, 502);
		addLane("Edge_10", 9, 10, 40);
		addLane("Edge_11", 1, 10, 600);

		// Lets check from location Loc_1 to Loc_10
		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(nodes.get(0));
		LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));

		Assert.assertNotNull(path);
		Assert.assertTrue(path.size() > 0);

		for (int i = 0; i < 10; i++) {
			String theSource = "Node_" + i;
			System.out.println("soruce: " + theSource);
			for (Edge edge : edges) {


				if (edge.getSource().getName().equals(theSource)) {
					System.out.println(edge.getDestination() + " : weight= " + edge.getWeight());
				}
			}
		}

		System.out.println("Path");
		System.out.print("from ");
		for (Vertex vertex : path) {

			System.out.print(vertex + " -> ");
		}
		System.out.print("Goal!");
		System.out.println();

		int sum = 0;
		for (int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i));
			if (i + 1 < path.size()) {

				int dist = dijkstra.getDistance(path.get(i), path.get(i + 1));
				sum += dist;
				System.out.print(" dist= " + dist + " -> ");
			}
		}
		System.out.println();
		System.out.println("sum = " + sum);
	}

	@Test
	public void testConvertMatrixToEdges() throws Exception {

		Random rnd = new Random();
//		int[][] matrix = {
//				{1, 2, 3},
//				{12, 2, 3},
//				{1, 2, 3},
//				{1, 2, 3},
//		};
		int[][] matrix = new int[20][10];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = rnd.nextInt(99) + 1;
			}
		}


		nodes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();


		System.out.println("matrix leng " + matrix.length);
		System.out.println("matrix i leng " + matrix[0].length);

		int nodeSize = matrix.length * matrix[0].length;
		System.out.println("nodeSize " + nodeSize);


		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[y].length; x++) {
				Vertex location = new Vertex("Node_(" + y + "," + x + ")", "Node_(" + y + "," + x + ")");
				nodes.add(location);
			}
		}

		Vertex toNode = nodes.get(99);
//		for (int i = 0; i < nodeSize; i++) {
//			Vertex location = new Vertex("Node_" + i, "Node_" + i);
//			nodes.add(location);
//		}

		int step = 0;


		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {

				/**
				 * when im at 0,0
				 * then neighbors are 0,1 and 1,0
				 * when im at 1,1
				 * then neigh are 1,2 and 2,1
				 */

				//if the next col is in matrix
				//add edge
				if ((j + 1) < matrix[i].length) {
					addLane(("Edge_" + step), step, (step + 1), matrix[i][j + 1]);
				}
				//if next row is in matrix
				//add edge
				if ((i + 1) < matrix.length) {
					int nextRowStep = step + matrix[i].length;
					addLane(("Edge_" + step), step, nextRowStep, matrix[i + 1][j]);
					//im on 0,0
					//then row below step is 4
				}
				step++;

			}

		}

		//end of creating
		//do the pathfinding

		// Lets check from location Loc_1 to Loc_10
		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(nodes.get(0));


		System.out.println("to " + toNode);

		LinkedList<Vertex> path = dijkstra.getPath(toNode);

		Assert.assertNotNull(path);
		Assert.assertTrue(path.size() > 0);
		System.out.println();

		//showNodeConnections(matrix);
		System.out.println();

		//showPath(path);
		System.out.println();

		showPathWithDistAndSum(dijkstra, path);
		System.out.println();

		//Node_(9,9)
		String[] xy = toNode.getName().substring(6).replace(")", "").trim().split(",");

		System.out.println("x= " + xy[0] + " y= " + xy[1]);
		int x = Integer.parseInt(xy[0]);
		int y = Integer.parseInt(xy[1]);

		//"Node_(" + y + "," + x + ")"

		boolean isNotInPath = true;
		//print matrix
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {


				for (Vertex pathNode : path) {
					if (pathNode.getName().equals("Node_(" + i + "," + j + ")")) {
//						System.out.println("in path " + "Node_(" + i + "," + j + ")");
						System.out.print("*" + matrix[i][j] + "*,\t");
						//			if (i == y && j == x) {
						//					System.out.print("*" + matrix[i][j] + "*,\t");
						isNotInPath = false;
					}
				}
				if (isNotInPath) {
					System.out.print(" "+matrix[i][j] + " ,\t");
				}
				isNotInPath= true;
			}
			System.out.println();
		}


	}

	private void showPathWithDistAndSum(DijkstraAlgorithm dijkstra, LinkedList<Vertex> path) {
		int sum = 0;
		for (int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i).getName());
			if (i + 1 < path.size()) {

				int dist = dijkstra.getDistance(path.get(i), path.get(i + 1));
				sum += dist;
				System.out.print(" dist= " + dist + " -> ");
			}
		}
		System.out.println("Goal!");
		System.out.println("sum = " + sum);
	}

	private void showPath(LinkedList<Vertex> path) {
		System.out.println("show Path");
		System.out.print("from ");
		for (Vertex vertex : path) {

			System.out.print(vertex + " -> ");
		}
		System.out.println("Goal!");
	}

	private void showNodeConnections(int[][] matrix) {
		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[y].length; x++) {
				String theSource = "Node_(" + y + "," + x + ")";
				System.out.println("soruce: " + theSource);
				for (Edge edge : edges) {


					if (edge.getSource().getName().equals(theSource)) {
						System.out.println(edge.getDestination() + " : weight= " + edge.getWeight());
					}
				}
			}
		}
	}

	private void addLane(String laneId, int sourceLocNo, int destLocNo,
	                     int duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
		edges.add(lane);
	}
}