package stringarrays.tries;

import datastructures.Queue;

/**
 * Definicao:
 * 
 * - Armazenar chars nos nós
 * 
 * - Cada nó terá 3 filhos: left, middle, right
 * 
 * 
 * Estrutura de Dado:
 * 
 * - TernarySearchTrie
 * 
 * 
 * Premissas:
 * 
 * 
 * Complexidade:
 * 
 * - Economia de espaço O((R=3+1)N)
 * 
 * - O(L+ln N characters); Hashing O(L), onde N = número de Strings e L = tamanho da String
 * 
 * - Tao rapido quanto hashs, mais eficiente em termos de espaço e mais flexivel
 * que Red-black BST
 * 
 * - Hashing
 * 
 * - Necessario examinar a chave
 * 
 * - hits/miss custam o mesmo
 * 
 * - performance depende da hashfunction
 * 
 * 
 * Aplicacao: Spellchecking, Auto-complete Suggester Solr TSTlookup
 * 
 * - prefix match: spellcheck
 * 
 * - longest prefix: ip prefix, T9 texting.
 * 
 * - Advanced: Patricia Trie = Radix Tree
 * 
 *
 */
public class TernarySearchTrie<Value> {

	private Node root;
	private static final int R = 256;

	private class Node {
		private Value val;
		private char c;
		private Node left, mid, right;
	}

	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return x.val;
	}

	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		char c = key.charAt(d);
		if (c < x.c)
			return get(x.left, key, d);
		else if (c > x.c)
			return get(x.right, key, d);
		else if (d < key.length() - 1)
			return get(x.mid, key, d + 1);
		else
			return x;
	}

	private Node put(Node x, String key, Value val, int d) {
		char c = key.charAt(d);
		if (x == null) {
			x = new Node();
			x.c = c;
		}
		if (c < x.c)
			x.left = put(x.left, key, val, d);
		if (c > x.c)
			x.right = put(x.right, key, val, d);
		else if (d < key.length() - 1)
			x.mid = put(x.mid, key, val, d + 1);
		else
			x.val = val;
		return x;

	}

}
