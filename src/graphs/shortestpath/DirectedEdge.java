package graphs.shortestpath;

import graphs.mst.Edge;
import graphs.mst.Vertex;

public class DirectedEdge extends Edge {

	public DirectedEdge(Vertex v, Vertex w, double weight) {
		super(v, w, weight);
	}

	public Vertex from() {
		return v;
	}

	public Vertex to() {
		return w;
	}

}
