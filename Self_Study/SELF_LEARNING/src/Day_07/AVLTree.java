package Day_07;

public class AVLTree {
	static class Node {
		private int data;
		private int height;
		private Node left;
		private Node right;

		public Node(int value) {
			data = value;
			height = 1;
			left = null;
			right = null;
		}
	}

	private Node root;

	public AVLTree() {
		root = null;
	}

	private int height(Node trav) {
		if(trav == null)
			return 0;
		return trav.height;
	}

	private int balanceFactor(Node trav) {
		if(trav == null)
			return 0;
		return height(trav.left) - height(trav.right);
	}

	private Node rightRotate(Node y) {
		Node x = y.left;
		Node t2 = x.right;

		x.right = y;
		y.left = t2;

		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;

		return x;
	}

	private Node leftRotate(Node x) {
		Node y = x.right;
		Node t2 = y.left;

		y.left = x;
		x.right = t2;

		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		return y;
	}

	public void addNode(int value) {
		root = addNode(root, value);
	}

	private Node addNode(Node trav, int value) {
		if(trav == null)
			return new Node(value);

		if(value < trav.data)
			trav.left = addNode(trav.left, value);
		else if(value > trav.data)
			trav.right = addNode(trav.right, value);
		else
			return trav;

		trav.height = Math.max(height(trav.left), height(trav.right)) + 1;

		int bf = balanceFactor(trav);

		if(bf > 1 && value < trav.left.data)
			return rightRotate(trav);

		if(bf < -1 && value > trav.right.data)
			return leftRotate(trav);

		if(bf > 1 && value > trav.left.data) {
			trav.left = leftRotate(trav.left);
			return rightRotate(trav);
		}

		if(bf < -1 && value < trav.right.data) {
			trav.right = rightRotate(trav.right);
			return leftRotate(trav);
		}

		return trav;
	}

	public void inorder() {
		inorder(root);
		System.out.println();
	}

	private void inorder(Node trav) {
		if(trav == null)
			return;

		inorder(trav.left);
		System.out.print(trav.data + " ");
		inorder(trav.right);
	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(Node trav) {
		if(trav == null)
			return;

		System.out.print(trav.data + " ");
		preorder(trav.left);
		preorder(trav.right);
	}
}
