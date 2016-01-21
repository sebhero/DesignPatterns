package Algorithms.Dijkstra_shoftestPath.model;

import java.util.List;

/**
 * Created by Sebastian Börebäck on 2016-01-21.
 */
public class Graph {

	final List<Vertex> vertexes;
	final List<Edge> edges;

	public Graph(List<Vertex> vertexes, List<Edge> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public List<Vertex> getVertexes() {
		return vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}
}
