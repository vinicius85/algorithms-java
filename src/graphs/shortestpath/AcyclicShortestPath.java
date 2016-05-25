package graphs.shortestpath;

import graphs.DepthFirstOrder;
import graphs.mst.EdgeWeigthedGraph;
import graphs.mst.Vertex;

/**
 * Premissa: DAG -> no directed cycles
 * 
 * Proposicao: Topological sort computa shortest path em qualquer aresta (mesmo
 * negativa) em um DAG em O(E + V)
 *
 * Estrutura de dados: Stack
 * 
 * Aplicacao: content-aware resizing (Seam carving), parallel job scheduling
 * 
 * mais rapido que Dijkstra, trata aresta negativas
 * 
 */
public class AcyclicShortestPath extends ShortestPath {

	public AcyclicShortestPath(EdgeWeigthedGraph G, int s) {
		super(G, s);
	}

	@Override
	void run() {
		DepthFirstOrder topological = new DepthFirstOrder(G);
		for (int v : topological.reversePost()) {
			for (DirectedEdge edge : G.adj(v))) {
				relax(edge);
			}
		}
	}

}
