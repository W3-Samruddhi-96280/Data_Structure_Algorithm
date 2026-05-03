package Day_05;

import java.util.Stack;

public class BinarySearchTree {
	static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int value) {
			data = value;
			left = null;
			right = null;
		}
	}

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void addNode(int value) {
		Node newnode = new Node(value);

		if(root == null) {
			root = newnode;
			return;
		}

		Node trav = root;
		while(true) {
			if(value < trav.data) {
				if(trav.left == null) {
					trav.left = newnode;
					break;
				}
				trav = trav.left;
			}
			else {
				if(trav.right == null) {
					trav.right = newnode;
					break;
				}
				trav = trav.right;
			}
		}
	}

	public void inorderRecursive() {
		inorderRecursive(root);
		System.out.println();
	}

	private void inorderRecursive(Node trav) {
		if(trav == null)
			return;

		inorderRecursive(trav.left);
		System.out.print(trav.data + " ");
		inorderRecursive(trav.right);
	}

	public void preorderRecursive() {
		preorderRecursive(root);
		System.out.println();
	}

	private void preorderRecursive(Node trav) {
		if(trav == null)
			return;

		System.out.print(trav.data + " ");
		preorderRecursive(trav.left);
		preorderRecursive(trav.right);
	}

	public void postorderRecursive() {
		postorderRecursive(root);
		System.out.println();
	}

	private void postorderRecursive(Node trav) {
		if(trav == null)
			return;

		postorderRecursive(trav.left);
		postorderRecursive(trav.right);
		System.out.print(trav.data + " ");
	}

	public void inorderIterative() {
		Stack<Node> stack = new Stack<>();
		Node trav = root;

		while(trav != null || !stack.isEmpty()) {
			while(trav != null) {
				stack.push(trav);
				trav = trav.left;
			}

			trav = stack.pop();
			System.out.print(trav.data + " ");
			trav = trav.right;
		}
		System.out.println();
	}

	public void preorderIterative() {
		if(root == null)
			return;

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()) {
			Node trav = stack.pop();
			System.out.print(trav.data + " ");

			if(trav.right != null)
				stack.push(trav.right);
			if(trav.left != null)
				stack.push(trav.left);
		}
		System.out.println();
	}

	public void postorderIterative() {
		if(root == null)
			return;

		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		s1.push(root);

		while(!s1.isEmpty()) {
			Node trav = s1.pop();
			s2.push(trav);

			if(trav.left != null)
				s1.push(trav.left);
			if(trav.right != null)
				s1.push(trav.right);
		}

		while(!s2.isEmpty())
			System.out.print(s2.pop().data + " ");

		System.out.println();
	}
}
