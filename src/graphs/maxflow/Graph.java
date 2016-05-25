package graphs.maxflow;

import java.util.ArrayList;
import java.util.List;

import graphs.mst.Edge;

public class Graph<T extends Edge> {

	private final int V;
	private List<List<T>> adj;

	public Graph(int V) {
		this.V = V;
		adj = new ArrayList<>();
		for (int v = 0; v < V; v++) {

		}
	}

	public void addEdge(T edge) {
		int v = edge.either().value();
		int w = edge.other(v);
		adj.get(v).add(edge);
		adj.get(w).add(edge);
	}

	public Iterable<T> adj(int v) {
		return adj.get(v);
	}

	public int V() {
		return V;
	}

}
