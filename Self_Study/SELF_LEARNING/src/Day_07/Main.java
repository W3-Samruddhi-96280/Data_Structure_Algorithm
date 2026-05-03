package Day_07;

public class Main {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createSampleTree();

		System.out.print("Binary Tree Inorder Recursive : ");
		bt.inorderRecursive();

		System.out.print("Binary Tree Preorder Recursive : ");
		bt.preorderRecursive();

		System.out.print("Binary Tree Postorder Recursive : ");
		bt.postorderRecursive();

		System.out.print("Binary Tree Inorder Iterative : ");
		bt.inorderIterative();

		System.out.print("Binary Tree Preorder Iterative : ");
		bt.preorderIterative();

		System.out.print("Binary Tree Postorder Iterative : ");
		bt.postorderIterative();

		System.out.println("Balanced : " + bt.isBalanced());
		System.out.println("Complete : " + bt.isComplete());
		System.out.println("Perfect : " + bt.isPerfect());
		System.out.println("Full : " + bt.isFull());

		AVLTree avl = new AVLTree();
		int[] values = {30, 20, 10, 40, 50, 25};

		for(int value : values)
			avl.addNode(value);

		System.out.print("AVL Inorder : ");
		avl.inorder();

		System.out.print("AVL Preorder : ");
		avl.preorder();
	}
}
