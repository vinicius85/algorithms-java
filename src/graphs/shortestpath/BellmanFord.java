package graphs.shortestpath;

import graphs.mst.EdgeWeigthedGraph;

/**
 * Premissa: SPT existe IFF nao existe negative cycle Negative cycle -> DCG soma
 * das arestas é negativa -> no negative cycles. Torna o problema intratável
 *
 * Definicao:
 *
 * Estrutura de dados: Queue
 *
 * Complexidade: O(EV)
 *
 * Aplicacoes: Arbitragem
 */
public class BellmanFord extends ShortestPath {

	public BellmanFord(EdgeWeigthedGraph G, int s) {
		super(G, s);
	}

	@Override
	void run() {
		for (int i = 0; i < G.numVertices(); i++)
			for (int v = 0; v < G.numVertices(); v++)
				for (DirectedEdge e : G.adj(v))
					relax(e);
	}

}
