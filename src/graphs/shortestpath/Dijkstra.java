package graphs.shortestpath;

import datastructures.IndexMinPQ;
import graphs.mst.EdgeWeigthedGraph;

/**
 * Em um grafo com arestas de pesos diferentes, calcular o menor caminho s->t
 *
 * Premissas: digrafo -> no negative weights
 * 
 * Tambem computa MST. Vertice proximo do source enquanto Prim, vertice proximo
 * da arvore
 * 
 * Estrutura de dados: Priority Queue (Binary Heap implementation)
 * 
 * Complexidade: depende da implementacao da PQ - O(V2) - array (grafo denso) /
 * Binary heap -> O(E log V) (grafo esparso) Almost linear quando pesos sao
 * nao-negativos
 * 
 */
public class Dijkstra extends ShortestPath {

	private IndexMinPQ<Double> pq;

	public Dijkstra(EdgeWeigthedGraph G, int s) {
		super(G, s);
		pq = new IndexMinPQ<>(G.numVertices());
		pq.insert(s, 0.0);
	}

	@Override
	public void run() {
		while (!pq.isEmpty()) {
			int v = pq.delMin();
			for (DirectedEdge e : G.adj(v)) {
				relax(e);
			}
		}
	}

	@Override
	void relax(DirectedEdge e) {
		int v = e.from().value(), w = e.to().value();
		if (distTo[w] > distTo(v) + e.getWeight()) {
			distTo[w] = distTo[v] + e.getWeight();
			edgeTo[w] = e;
			if (pq.contains(w))
				pq.decreaseKey(w, distTo[w]);
			else
				pq.insert(w, distTo[w]);
		}
	}

}
