package Algorithms.Dijkstra_shoftestPath.model;

/**
 * Created by Sebastian Börebäck on 2016-01-21.
 */
public class Edge {

	final String id;
	final Vertex source;
	final Vertex destination;
	final int weight;

	public Edge(String id, Vertex source, Vertex destination, int weight) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return source + " " + destination;
	}

	public String getId() {
		return id;
	}

	public Vertex getSource() {
		return source;
	}

	public Vertex getDestination() {
		return destination;
	}

	public int getWeight() {
		return weight;
	}
}
