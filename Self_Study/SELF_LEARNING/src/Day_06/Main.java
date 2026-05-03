package Day_06;


public class Main {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int[] values = {5, 3, 1, 4, 7, 2, 6, 8, 9, 0};

		for(int value : values)
			bst.addNode(value);

		System.out.print("Before Delete : ");
		bst.inorder();

		bst.deleteNode(3);

		System.out.print("After Delete : ");
		bst.inorder();

		System.out.println("Balanced : " + bst.isBalanced());
		System.out.println("Complete : " + bst.isComplete());
		System.out.println("Perfect : " + bst.isPerfect());
		System.out.println("Full : " + bst.isFull());
	}
}
