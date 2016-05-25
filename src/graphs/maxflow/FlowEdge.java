package graphs.maxflow;

import graphs.mst.Edge;
import graphs.mst.Vertex;

public class FlowEdge extends Edge {

	private final int v, w;
	private final double capacity;
	private double flow;

	public FlowEdge(int v, int w, int capacity) {
		super(new Vertex(new Character((char)v)), new Vertex(new Character((char)w)), capacity);
		this.v = v;
		this.w = w;
		this.capacity = capacity;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	public double capacity() {
		return capacity;
	}

	public double flow() {
		return flow;
	}

	public double residualCapacityTo(int vertex) {
		if (vertex == v)
			return flow;
		else if (vertex == w)
			return capacity - flow;
		else
			throw new IllegalArgumentException();
	}

	public double addResidualFlowTo(int vertex, double delta) {
		if (vertex == v)
			return flow -= delta;
		else if (vertex == w)
			return flow += delta;
		else
			throw new IllegalArgumentException();
	}

}
