package Day_06;



import java.util.Scanner;

public class Day06_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BST tree = new BST();

		tree.addNode(50);
		tree.addNode(30);
		tree.addNode(70);
		tree.addNode(20);
		tree.addNode(40);
		tree.addNode(60);
		tree.addNode(80);

		tree.inorder();

		System.out.print("Enter key to search : ");
		int key = sc.nextInt();

		if(tree.searchNode(key) != null)
			System.out.println("Key found");
		else
			System.out.println("Key not found");

		sc.close();
	}
}
