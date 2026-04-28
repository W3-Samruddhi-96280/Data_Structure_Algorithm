package Day_05;



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
		// case 1 empty tree or leaf position found
		if(trav == null)
			return new Node(value);

		// case 2 value is smaller
		if(value < trav.data)
			trav.left = addNode(trav.left, value);

		// case 3 value is greater
		else if(value > trav.data)
			trav.right = addNode(trav.right, value);

		// case 4 duplicate value
		else
			System.out.println("Duplicate value not allowed");

		return trav;
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
