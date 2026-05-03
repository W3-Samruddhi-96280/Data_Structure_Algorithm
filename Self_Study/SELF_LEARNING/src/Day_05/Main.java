package Day_05;

public class Main {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int[] values = {5, 3, 1, 4, 7, 2, 6, 8, 9, 0};

		for(int value : values)
			bst.addNode(value);

		System.out.print("Inorder Recursive : ");
		bst.inorderRecursive();

		System.out.print("Preorder Recursive : ");
		bst.preorderRecursive();

		System.out.print("Postorder Recursive : ");
		bst.postorderRecursive();

		System.out.print("Inorder Iterative : ");
		bst.inorderIterative();

		System.out.print("Preorder Iterative : ");
		bst.preorderIterative();

		System.out.print("Postorder Iterative : ");
		bst.postorderIterative();
	}
}
