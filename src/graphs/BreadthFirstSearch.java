package graphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datastructures.Queue;

public class BreadthFirstSearch {

	private boolean[] marked;
	private int[] edgeTo;
	private List<Character> path;

	public BreadthFirstSearch(Graph G) {
		marked = new boolean[G.numVertices()];
		edgeTo = new int[G.numVertices()];
		path = new ArrayList<>();
	}

	public void bfs(Graph G, int source) {
		Queue<Integer> q = new Queue<>();
		q.enqueue(source);
		marked[source] = true;
		while (!q.isEmpty()) {
			int v = q.dequeue();
			path.add((char)(v+65));
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					q.enqueue(w);
					marked[w] = true;
					edgeTo[w] = v;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		Graph g = new Graph("src/resources/directed-bfs", "src/resources/directed-bfs-adjacency-list", Traversal.PRE_ORDER, false);
		BreadthFirstSearch bfs = new BreadthFirstSearch(g);
		bfs.bfs(g, 0);
		System.out.println(bfs.path);
	}

}
