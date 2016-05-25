package stringarrays.tries;

import datastructures.Queue;

/**
 * Definicao:
 * 
 * - reTRIEval de Strings, em tempo linear, mais performático que Red-black BST
 * 
 * Estrutura de Dado:
 * 
 * - Trie: árvore onde cada nó é um caracter da String e a folha contém um valor
 * 
 * Premissas:
 * 
 * Complexidade:
 * 
 * - Search hit: Examinar L chars O(n)
 * 
 * - Search miss: examinar alguns chars (sublinear) R null links a cada folha
 * 
 * - Hits e misses muito rápido, mas necessita de espaço considerável
 * 
 * - Desafio: usar menos memoria para trie
 * 
 * 
 * Aplicacao:
 * 
 * - Spellchecking: 26-way trie
 *
 */
public class Trie<Value> {

	private static final int R = 256;
	private Node root = new Node();

	private static class Node {
		private Object val;
		private Node[] next = new Node[R];

	}

	public void put(String key, String val) {

	}

	private Node put(Node x, String key, Value val, int d) {
		if (x == null)
			x = new Node();
		if (d == key.length()) {
			x.val = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}

	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return (Value) x.val;
	}

	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length())
			return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d + 1);
	}

	public Iterable<String> keys() {
		Queue<String> queue = new Queue<>();
		collect(root, "", queue);
		return queue;
	}

	private void collect(Node x, String prefix, Queue<String> q) {
		if (x == null)
			return;
		if (x.val != null)
			q.enqueue(prefix);
		for (char c = 0; c < R; c++)
			collect(x.next[c], prefix, q);
	}

}
