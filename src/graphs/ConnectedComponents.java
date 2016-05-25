package graphs;

import java.io.IOException;

public class ConnectedComponents {

	private boolean[] marked;
	private int[] id;
	private int count;

	public ConnectedComponents(Graph G, boolean isSCC) {
		this.marked = new boolean[G.V()];
		this.id = new int[G.V()];
		if (!isSCC) {
			for (int v = 0; v < G.V(); v++) {

				if (!marked[v]) {
					dfs(G, v);
					count++;
				}
			}
		} else {
			DepthFirstSearch dfs = new DepthFirstSearch(G.reverse());
			for (char v : dfs.reversePost()) {
				int vertex = v - 65;
				if (!marked[vertex]) {
					dfs(G, vertex);
					count++;
				}
			}
		}

	}

	private void dfs(Graph g, int v) {
		marked[v] = true;
		id[v] = count;
		System.out.println(id[v] + "-" + (new Character((char) (v + 65))));
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				dfs(g, w);
			}
		}
	}

	public int count() {
		return count;
	}

	public int id(int v) {
		return id[v];
	}

	public static void main(String[] args) throws IOException {
		Graph g = new Graph("src/resources/scc", "src/resources/cc-adjacency-list.txt", Traversal.PRE_ORDER,
				false);
		new ConnectedComponents(g, true);

	}

}
