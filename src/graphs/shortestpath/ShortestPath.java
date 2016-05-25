package graphs.shortestpath;

import java.util.Stack;

import graphs.mst.EdgeWeigthedGraph;

public abstract class ShortestPath {

	protected double[] distTo;
	protected DirectedEdge[] edgeTo;
	protected EdgeWeigthedGraph G;
	
	public ShortestPath(EdgeWeigthedGraph G, int s){
		this.G = G;
		distTo = new double[G.numVertices()];
		edgeTo = new DirectedEdge[G.numVertices()];
		distTo[s] = 0.0;
		for(int v = 0; v < G.numVertices(); v++){
			distTo[v] = Double.POSITIVE_INFINITY;
		}
	}

	double distTo(int v) {
		return distTo[v];
	}

	Iterable<DirectedEdge> pathTo(int v) {
		Stack<DirectedEdge> path = new Stack<>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from().value()]) {
			path.push(e);
		}
		return path;
	}

	boolean hasPathTo(int v) {
		return false;
	}

	void relax(DirectedEdge e) {
		int v = e.from().value(), w = e.to().value();
		if (distTo[w] > distTo(v) + e.getWeight()) {
			distTo[w] = distTo[v] + e.getWeight();
			edgeTo[w] = e;
		}
	}
	
	abstract void run();

}
