package Day_08;


public class BST {
	static class node 
	{
		node left;
		int data;
		node right;
		
		node(int data)
		{
			this.data=data;
			left=null;
			right=null;
		}
	}
	node root;
	
	{
		root=null;
	}
	private void add(node trav,int data)
	{
		node nn=new node(data);
		if(root==null)
		{
			root=nn;
			return;
		}
		if(data<trav.data)
		{
			if(trav.left==null)
			{
				trav.left=nn;
				return;
			}
			else
				add(trav.left,data);
		}
		else
		{
			if(trav.right==null)
			{
				trav.right=nn;
				return;
			}
			else
				add(trav.right,data);
		}
			
	}
	public void add(int data)
	{
		add(root,data);
	}

	private void preorder(node trav)
	{
		if(trav==null)
			return;
		System.out.print("->"+trav.data);
		preorder(trav.left);
		preorder(trav.right);
	}
	public void preorder()
	{
		System.out.print("Pre:");
		preorder(root);
		System.out.println();
	}
	private void inorder(node trav)
	{
		if(trav==null)
			return;
		inorder(trav.left);
		System.out.print("->"+trav.data);
		inorder(trav.right);
	}
	public void inorder()
	{
		System.out.print("In:");
		inorder(root);
		System.out.println();
	}
	private void inorderDesc(node trav)
	{
		if(trav==null)
			return;
		inorderDesc(trav.right);
		System.out.print("->"+trav.data);
		inorderDesc(trav.left);
	}
	public void inorderDesc()
	{
		System.out.print("InDesc:");
		inorderDesc(root);
		System.out.println();
	}
	private void postorder(node trav)
	{
		if(trav==null)
			return;
		postorder(trav.left);
		postorder(trav.right);
		System.out.print("->"+trav.data);
	}
	public void postorder()
	{
		System.out.print("Post:");
		postorder(root);
		System.out.println();
	}
	
	public node search(int data)
	{
		node trav=root;
		while(trav!=null)
		{
			if(data==trav.data)
				return trav;
			if(data<trav.data)
				trav=trav.left;
			else
				trav=trav.right;
		}
		return null;
	}
	private void serachRecursive(node trav,int data)
	{
		if(trav==null)
		{
			System.out.println("Data not found");
			return;
		}
		if(data==trav.data)
			System.out.println("Data found");
		else if(data<trav.data)
			serachRecursive(trav.left,data);
		else
			serachRecursive(trav.right,data);
		
	}
	public void serachRe(int data)
	{
		serachRecursive(root,data);
	}
	public node[] searchWithParent(int data)
	{
		node trav=root;
		node parent=null;
		while(trav!=null)
		{
			if(data==trav.data)
				return new node[] {trav,parent};
			parent=trav;
			if(data<trav.data)
				trav=trav.left;
			else
				trav=trav.right;
		}
		return new node[] {null,null};
	}
	public void delete(int val)
	{
		node [] find=searchWithParent(val);
		node trav=find[0];
		node parent=find[1];
		if(trav==null)
		{
			System.out.println("Data didnt found");
			return;
		}
		if(trav.right!=null&&trav.left!=null)
		{
			parent=trav;
			node succ=trav.right;
			while(succ.left!=null)
			{
				parent=succ;
				succ=succ.left;
			}
			trav.data=succ.data;
			trav=succ;
		}
		if(trav.left==null)
		{
			if(trav==root)
				root=trav.right;
			else if(trav==parent.left)
				parent.left=trav.right;
			else
				parent.right=trav.right;
		}
		else
		{
			if(trav==root)
				root=trav.left;
			else if(trav==parent.left)
				parent.left=trav.left;
			else
				parent.right=trav.left;
		}
	}
}
