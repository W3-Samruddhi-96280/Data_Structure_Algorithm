package Day_06;

import java.util.LinkedList;
import java.util.Queue;

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

	public void deleteNode(int value) {
		root = deleteNode(root, value);
	}

	private Node deleteNode(Node trav, int value) {
		if(trav == null)
			return null;

		if(value < trav.data)
			trav.left = deleteNode(trav.left, value);
		else if(value > trav.data)
			trav.right = deleteNode(trav.right, value);
		else {
			if(trav.left == null)
				return trav.right;

			if(trav.right == null)
				return trav.left;

			Node succ = getSuccessor(trav.right);
			trav.data = succ.data;
			trav.right = deleteNode(trav.right, succ.data);
		}
		return trav;
	}

	private Node getSuccessor(Node trav) {
		while(trav.left != null)
			trav = trav.left;
		return trav;
	}

	public boolean isBalanced() {
		return isBalanced(root) != -1;
	}

	private int isBalanced(Node trav) {
		if(trav == null)
			return 0;

		int lh = isBalanced(trav.left);
		if(lh == -1)
			return -1;

		int rh = isBalanced(trav.right);
		if(rh == -1)
			return -1;

		if(Math.abs(lh - rh) > 1)
			return -1;

		return Math.max(lh, rh) + 1;
	}

	public boolean isComplete() {
		if(root == null)
			return true;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		boolean nullFound = false;

		while(!queue.isEmpty()) {
			Node trav = queue.remove();

			if(trav == null)
				nullFound = true;
			else {
				if(nullFound)
					return false;
				queue.add(trav.left);
				queue.add(trav.right);
			}
		}
		return true;
	}

	public boolean isFull() {
		return isFull(root);
	}

	private boolean isFull(Node trav) {
		if(trav == null)
			return true;

		if(trav.left == null && trav.right == null)
			return true;

		if(trav.left != null && trav.right != null)
			return isFull(trav.left) && isFull(trav.right);

		return false;
	}

	public boolean isPerfect() {
		int depth = leftDepth(root);
		return isPerfect(root, depth, 0);
	}

	private int leftDepth(Node trav) {
		int depth = 0;
		while(trav != null) {
			depth++;
			trav = trav.left;
		}
		return depth;
	}

	private boolean isPerfect(Node trav, int depth, int level) {
		if(trav == null)
			return true;

		if(trav.left == null && trav.right == null)
			return depth == level + 1;

		if(trav.left == null || trav.right == null)
			return false;

		return isPerfect(trav.left, depth, level + 1) && isPerfect(trav.right, depth, level + 1);
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
}
