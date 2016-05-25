package graphs.mst;

import java.io.IOException;

import datastructures.MinPQ;
import datastructures.UF;

/**
 * Runtime E log(E)
 *
 */
public class KruskalMST extends MinimumSpanningTrees {

	public KruskalMST(EdgeWeigthedGraph G) {
		super(G);
	}

	// orderna os vertices em relacao ao peso
	// adiciona a MST os vertices minimos que nao criem ciclos
	public void run() {
		MinPQ<Edge> pq = new MinPQ<>();
		for (Edge e : this.G.edges()) {
			pq.insert(e);
		}
		UF unionFind = new UF(G.numVertices());
		while (!pq.isEmpty() && mst.size() < G.numVertices() - 1) {
			Edge e = pq.delMin();
			Vertex v = e.either();
			Vertex w = e.other(v);
			if (!unionFind.connected(v.value(), w.value())) {
				unionFind.union(v.value(), w.value());
				mst.enqueue(e);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		MinimumSpanningTrees kruskal = new KruskalMST(
				new EdgeWeigthedGraph("src/resources/kruskal"));
		kruskal.run();
		System.out.println(kruskal.edges());
	}

}
