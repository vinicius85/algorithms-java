package graphs.mst;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import graphs.Graph;
import graphs.shortestpath.DirectedEdge;

public class EdgeWeigthedGraph extends Graph {

	public EdgeWeigthedGraph(String input) throws IOException {
		super(input);
	}

	public void addEdge(DirectedEdge e) {
		Vertex v = e.either();
		Vertex w = e.other(v);
		this.adj.get(v.value()).add(e);
		this.adj.get(w.value()).add(e);
	}

	public Iterable<Edge> edges() {
		List<Edge> list = new ArrayList<Edge>();
		for (int v = 0; v < V; v++) {
			int selfLoops = 0;
			for (Edge e : adj(new Vertex((char) v))) {
				if (e.other(v) > v) {
					list.add(e);
				} else if (e.other(v) == v) {
					if (selfLoops % 2 == 0)
						list.add(e);
					selfLoops++;
				}
			}
		}
		return list;
	}

}
