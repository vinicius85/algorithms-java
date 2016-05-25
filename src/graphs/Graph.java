package graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import graphs.mst.Edge;
import graphs.mst.Vertex;

public class Graph {

	protected final int V;
	protected List<List<Edge>> adj;

	public Graph(String input, String output, Traversal traversal, boolean isReverse) throws IOException {

		BuildAdjacencyList.createAdjacencyList(input, output, traversal, isReverse);
		BufferedReader reader = new BufferedReader(new FileReader(output));
		this.V = Integer.parseInt(reader.readLine());

		adj = new ArrayList<List<Edge>>();
		for (int v = 0; v < V; v++) {
			adj.add(new ArrayList<Edge>());
		}

		reader.lines().forEach(line -> {
			String[] edgeArray = line.split(" ");
			addEdge(new Edge(new Vertex(edgeArray[0].charAt(0)), new Vertex(edgeArray[1].charAt(0)), 0.0));
		});

		reader.close();
	}

	public Graph(String input, String output) throws IOException {
		this(input, output, Traversal.PRE_ORDER, false);
	}

	public Graph(String input) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(input));
		this.V = Integer.parseInt(reader.readLine());
		adj = new ArrayList<List<Edge>>();
		for (int v = 0; v < V; v++) {
			adj.add(new ArrayList<Edge>());
		}

		reader.lines().forEach(line -> {
			String[] edgeArray = line.split(" ");
			addEdge(new Edge(new Vertex(edgeArray[0].charAt(0)), new Vertex(edgeArray[1].charAt(0)),
					Double.valueOf(edgeArray[2])));
		});

		reader.close();
	}

	public Graph(int V) {
		this.V = V;
		this.adj = new ArrayList<List<Edge>>();
		for (int v = 0; v < V; v++) {
			adj.add(new ArrayList<Edge>());
		}
	}

	public void addEdge(Edge e) {
		Vertex v = e.either();
		Vertex w = e.other(v);
		this.adj.get(v.value()).add(e);
		this.adj.get(w.value()).add(e);
	}

	public Iterable<Edge> adj(Vertex v) {
		return adj.get(v.index());
	}

	public int numVertices() {
		return V;
	}

	public Graph reverse() {
		Graph R = new Graph(V);
		for (int v = 0; v < V; v++) {
			for (Edge edge : adj(new Vertex((char) v))) {
				R.addEdge(edge);
			}
		}
		return R;
	}

}
