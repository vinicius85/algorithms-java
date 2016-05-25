package trees;

public class BinarySearchTree {

	/**
	 * O(log n) no caso médio. Mas O(n) no caso de uma arvore com elementos
	 * ordenados (lista ligada) Insercao e delecao tambem sao O(log n)
	 */
	public Node findNode(Node root, int value) {
		int current = root.getValue();
		if (current == value) {
			return root;
		}
		root = (current < value) ? root = root.getLeft() : root.getRight();
		return root;
	}

	public Node findNodeRecursively(Node node, int value) {
		if (node == null)
			return null;
		int current = node.getValue();
		if (current == value) {
			return node;
		}
		if (current < value) {
			return findNode(node.getLeft(), current);
		} else {
			return findNode(node.getRight(), current);
		}
	}
}
