package Day_05;

public class Day05_Main {
	public static void main(String[] args) {
		BST tree = new BST();

		tree.addNode(50);
		tree.addNode(30);
		tree.addNode(70);
		tree.addNode(20);
		tree.addNode(40);
		tree.addNode(60);
		tree.addNode(80);

		tree.inorder();
	}
}
