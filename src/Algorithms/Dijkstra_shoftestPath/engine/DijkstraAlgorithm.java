package Algorithms.Dijkstra_shoftestPath.engine;

import Algorithms.Dijkstra_shoftestPath.model.Edge;
import Algorithms.Dijkstra_shoftestPath.model.Graph;
import Algorithms.Dijkstra_shoftestPath.model.Vertex;

import java.util.*;

/**
 * Created by Sebastian Börebäck on 2016-01-21.
 * Link: http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html
 */
public class DijkstraAlgorithm {

	final List<Vertex> nodes;
	final List<Edge> edges;
	Set<Vertex> settledNodes;
	Set<Vertex> unSettledNodes;
	Map<Vertex, Vertex> predecessors;
	Map<Vertex, Integer> distance;
	private int sum;

	public DijkstraAlgorithm(Graph graph) {
		//create a copy of the array so that we can operate on this array;
		this.nodes = new ArrayList<>(graph.getVertexes());
		this.edges = new ArrayList<>(graph.getEdges());
	}

	public void execute(Vertex source) {
		settledNodes = new HashSet<>();
		unSettledNodes = new HashSet<>();
		distance = new HashMap<>();
		predecessors = new HashMap<>();
		distance.put(source, 0);
		unSettledNodes.add(source);
		sum = 0;
		while (unSettledNodes.size() > 0) {
			Vertex node = getMinimum(unSettledNodes);
			sum++;
//			System.out.println("checking node: "+node.getName()+" checks: "+nbrOfChecks);
			settledNodes.add(node);
			unSettledNodes.remove(node);

			findMinimalDistances(node);
		}
		System.out.println("checks before found shortest path  "+sum);

	}

	private Vertex getMinimum(Set<Vertex> vertexes) {
		Vertex minimum = null;
		for (Vertex vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}



	private void findMinimalDistances(Vertex node) {
		List<Vertex> adjacentNodes = getNeighbors(node);
		for (Vertex target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node)
					+ getDistance(node, target)) {

				distance.put(target, getShortestDistance(node)+getDistance(node,target));
				predecessors.put(target, node);
				unSettledNodes.add(target);

			}
		}

	}

	public int getDistance(Vertex fromNode, Vertex target) {
		for (Edge edge : edges) {
			if (edge.getSource().equals(fromNode) && edge.getDestination().equals(target)) {
				return edge.getWeight();
			}
		}
		throw new RuntimeException("Should not happen!");
	}

	private List<Vertex> getNeighbors(Vertex node) {

		List<Vertex> neighbors = new ArrayList<>();
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}

	private boolean isSettled(Vertex vertex) {

		return settledNodes.contains(vertex);
	}

	private int getShortestDistance(Vertex destination) {

		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	/*
   * This method returns the path from the source to the selected target and
   * NULL if no path exists
   */

	public LinkedList<Vertex> getPath(Vertex target) {
		LinkedList<Vertex> path = new LinkedList<>();
		Vertex step = target;
		// Check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}


}
