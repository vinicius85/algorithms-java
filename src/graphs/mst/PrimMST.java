package graphs.mst;

import datastructures.MinPQ;
import datastructures.Queue;

/**
 * Encontrar min-weight - Priority Queue log(E)
 *
 * Runtime E log(V) - depende da implementacao da PQ
 * 
 * Lazy implementation
 */
public class PrimMST extends MinimumSpanningTrees {

	private boolean[] marked;
	private MinPQ<Edge> pq;

	public PrimMST(EdgeWeigthedGraph G) {
		super(G);
		pq = new MinPQ<>();
		mst = new Queue<>();
		marked = new boolean[G.numVertices()];
		visit(G, new Vertex('A'));
	}

	@Override
	public void run() {
		while (!pq.isEmpty() && mst.size() < G.numVertices() - 1) {
			Edge e = pq.delMin();
			Vertex V = e.either();
			Vertex W = e.other(V);
			int v = V.value();
			int w = W.value();
			if (marked[v] && marked[w])
				continue;
			mst.enqueue(e);
			if (!marked[v])
				visit(G, V);
			if (!marked[w])
				visit(G, W);
		}
	}

	private void visit(EdgeWeigthedGraph G, Vertex v) {
		marked[v.value()] = true;
		for (Edge e : G.adj(v)) {
			if (!marked[(e.other(v)).value()]) {
				pq.insert(e);
			}
		}
	}

}
