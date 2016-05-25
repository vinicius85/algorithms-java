package graphs;

import java.io.IOException;
import java.util.Stack;

public class DepthFirstOrder {
	private boolean[] marked;
	private Stack<Integer> reversePost;

	public DepthFirstOrder(Graph G) {
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		for (int v = 0; v < G.V(); v++)
			if (!marked[v])
				dfs(G, v);
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
		reversePost.push(v);
	}

	public Iterable<Integer> reversePost() {
		return reversePost;
	}

	public static void main(String[] args) throws IOException {
		Graph graph = new Graph("src/resources/topologicalSort", "src/resources/topological-adjacency-list",
				Traversal.POST_ORDER, false);
		DepthFirstOrder dfs = new DepthFirstOrder(graph);
		System.out.println(dfs.reversePost);
	}
}
