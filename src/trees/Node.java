package trees;

public class Node {

	private final Node right;
	private final Node left;
	private final int value;

	public Node(Node right, Node left, int value) {
		super();
		this.right = right;
		this.left = left;
		this.value = value;
	}

	public Node getRight() {
		return right;
	}

	public Node getLeft() {
		return left;
	}

	public int getValue() {
		return value;
	}

}
