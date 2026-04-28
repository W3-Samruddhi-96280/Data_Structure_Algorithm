package Day_06;



public class BST {
	// node class
	static class Node {
		// data members
		private int data;
		private Node left;
		private Node right;

		// constructor
		public Node(int value) {
			data = value;
			left = null;
			right = null;
		}
	}

	// data members
	private Node root;

	// constructor
	public BST() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
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
			System.out.println("Duplicate value not allowed");

		return trav;
	}

	public Node searchNode(int key) {
		return searchNode(root, key);
	}

	private Node searchNode(Node trav, int key) {
		// case 1 tree empty or key not found
		if(trav == null)
			return null;

		// case 2 key found
		if(key == trav.data)
			return trav;

		// case 3 search in left subtree
		else if(key < trav.data)
			return searchNode(trav.left, key);

		// case 4 search in right subtree
		else
			return searchNode(trav.right, key);
	}

	public void inorder() {
		System.out.print("Inorder : ");
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
}
