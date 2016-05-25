package graphs;

import java.io.IOException;

public class KosarajuSCC {

	private boolean marked[];
	private int[] id;
	private int count;

	public KosarajuSCC(Graph G) {
		marked = new boolean[G.numVertices()];
		id = new int[G.numVertices()];
		int reverse[] = {2, 8, 7, 9, 4, 3, 0, 1 ,6 ,5};
		for (int v : reverse) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
	}

	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}

	public static void main(String[] args) throws IOException {
		Graph g = new Graph("src/resources/scc", "src/resources/cc-adjacency-list.txt", Traversal.PRE_ORDER, false);
		KosarajuSCC scc = new KosarajuSCC(g);
		for (int v : scc.id) {
			System.out.println(v);
		}

	}
}
