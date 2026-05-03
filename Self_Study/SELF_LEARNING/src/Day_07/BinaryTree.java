package Day_07;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
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

	public BinaryTree() {
		root = null;
	}

	public void createSampleTree() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
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
}
