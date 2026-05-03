package Day_08;


public class BSTMain {
	public static void main(String [] args)
	{
		BST list=new BST();
		list.add(17);
		list.add(2);
		list.add(20);
		list.add(15);
		list.add(1);
		list.add(25);
		list.add(18);
		//list.preorder();
		list.inorder();
		//list.postorder();
		//list.delete(17);
		//list.postorder();
		//list.inorder();
		//list.serachRe(26);
		list.inorderDesc();
	}

}
