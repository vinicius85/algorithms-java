package graphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * DFS 
 * - Datastructure - Stack (recursive) 
 * - Find a path between two vertices - DFS marks all vertices connected to s in time proportional to the sum of
 * their degrees 
 * - Após a construcao da estrtutura - Encontrar vertices
 * conectados a s em tempo constante - encontrar o caminho s->v em tempo
 * proporcional a distancia entre os nós 
 * - SCC 
 * - Detectar ciclos 
 * - Labirintos (apenas uma unica solucao) 
 * - bipartite
 * 
 * Topological Sorting
 * 
 * Executar tarefas em que a ordem importa por conta de restrições DAG -
 * directed acyclic graph - nao existe ciclos Resolvido com algoritmo DFS
 * Retornar vertices de um DAG percorridos em pos-ordem reversa Planejamento,
 * scheduler - listar as tarefas que dependem umas das outras, definir essas
 * restricoes e entao rodar o DFS em cima do DAG, retornar o reversePost() e
 * voce tera a sequencia de passos que teria que executar para finalizar uma
 * tarefa
 *
 */
public class DepthFirstSearch {

	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	private List<Character> path;
	private Stack<Character> topologicalSort;

	public DepthFirstSearch(Graph G) {
		marked = new boolean[G.numVertices()];
		edgeTo = new int[G.numVertices()];
		path = new ArrayList<>();
		topologicalSort = new Stack<>();
		for (int v = 0; v < G.numVertices(); v++) {
			if (!marked[v])
				dfs(G, v);
		}
	}

	public void dfs(Graph G, int v) {
		marked[v] = true;
		char vertex = (char) (v + 65);
		path.add(vertex);
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
				edgeTo[w] = v;
			}
		}
		topologicalSort.push(vertex);
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Stack<Character> getTopologicalSort(){
		return topologicalSort;
	}
	
	public Stack<Character> reversePost(){
		Stack<Character> reverseOrder = new Stack<>();
		for (Character vertex : topologicalSort) {
			reverseOrder.push(vertex);
		}
		return reverseOrder;
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> stack = new Stack<>();
		for (int x = v; x != s; x = edgeTo[x]) {
			stack.push(x);
		}
		stack.push(s);
		return stack;
	}

	public static void main(String[] args) throws IOException {
		Graph graph = new Graph("src/resources/topologicalSort", "src/resources/topological-adjacency-list",
				Traversal.POST_ORDER,false);
		DepthFirstSearch dfs = new DepthFirstSearch(graph);
		System.out.println(dfs.path);
		System.out.println(dfs.getTopologicalSort());
	}

}
