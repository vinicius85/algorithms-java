package graphs.maxflow;

import datastructures.Queue;

public class FordFulkerson {

	private boolean[] marked;
	private FlowEdge[] edgeTo;
	private double value;

	public FordFulkerson(Graph<FlowEdge> G, int s, int t) {
		value = 0.0;

		while (hasAugmentingPath(G, s, t)) {
			double bottle = Double.POSITIVE_INFINITY;

			for (int v = t; v != s; v = edgeTo[v].other(v))
				bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));

			for (int v = t; v != s; v = edgeTo[v].other(v))
				edgeTo[v].addResidualFlowTo(v, bottle);

			value += bottle;
		}
	}

	public double value() {
		return value;
	}

	public boolean inCut(int v) {
		return marked[v];
	}

	private boolean hasAugmentingPath(Graph<FlowEdge> G, int s, int t) {
		edgeTo = new FlowEdge[G.V()];
		marked = new boolean[G.V()];

		Queue<Integer> queue = new Queue<>();
		queue.enqueue(s);
		marked[s] = true;

		while (!queue.isEmpty()) {

			Integer v = queue.dequeue();

			for (FlowEdge e : G.adj(v)) {
				int w = e.other(v);
				if (e.residualCapacityTo(w) > 0 && !marked[w]) {
					edgeTo[w] = e;
					marked[w] = true;
					queue.enqueue(w);
				}
			}
		}
		return marked[t];
	}
}
