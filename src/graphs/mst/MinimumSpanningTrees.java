package graphs.mst;

import datastructures.Queue;

/**
 * Subgrafo que conecta todos os vértices sem gerar ciclos, com o menor custo
 * possível E = V - 1
 * 
 * Greedy Algorithm to find MST - Algoritmo guloso para resolver isso
 * 
 * Premissas que garante a existencia e unicidade de uma MST: grafo conectado
 * nao-direcional e arestas de pesos distintos
 * 
 * Cut: particiona o grafo em partes nao vazias
 * 
 * Crossing edge: conecta vertices de particoes distintas
 * 
 * Para qualquer particao, o vertice que conecta as particoes de menor peso está
 * na MST. O algoritmo guloso irá varrer possiveis crossing-edges para verificar
 * o de peso minimo e incluir na MST Kruskal e Prim sao implementacoes
 * eficientes de Greedy para computar MSTs
 * 
 * Se o Grafo nao é conectado = Minimum spanning forest = MST de cada componente
 * 
 * Aplicacao: extrair as relacoes mais fortes de compra que ligam todos os
 * vertices de cada connected components. Objetivo: Promover sequencia de
 * produtos em um email?
 * 
 * O(E log E) Open-question O(E): nao existe algoritmo linear
 * 
 * Usado para clustering: Executar Kruskal e parar quando identificar k
 * connected components
 * 
 */
public abstract class MinimumSpanningTrees {

	protected Queue<Edge> mst = new Queue<Edge>();
	protected double weight = 0.0;
	protected EdgeWeigthedGraph G;

	public MinimumSpanningTrees(EdgeWeigthedGraph G) {
		this.G = G;
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public void weight() {
		mst.forEach(edge -> weight += edge.getWeight());
	}

	abstract void run();

}
