package Day5;

import java.util.Stack;

class BSTNode {
    int data;
    BSTNode left, right;

    public BSTNode(int val) {
        data = val;
        left = right = null;
    }
}

public class BSTMain {
    private BSTNode root;

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private BSTNode insertRec(BSTNode root, int key) {
        if (root == null) return new BSTNode(key);
        if (key < root.data) root.left = insertRec(root.left, key);
        else if (key > root.data) root.right = insertRec(root.right, key);
        return root;
    }

    // --- RECURSIVE TRAVERSALS ---
    public void recursiveInorder(BSTNode node) {
        if (node == null) return;
        recursiveInorder(node.left);
        System.out.print(node.data + " ");
        recursiveInorder(node.right);
    }

    public void recursivePreorder(BSTNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        recursivePreorder(node.left);
        recursivePreorder(node.right);
    }

    public void recursivePostorder(BSTNode node) {
        if (node == null) return;
        recursivePostorder(node.left);
        recursivePostorder(node.right);
        System.out.print(node.data + " ");
    }

    // --- ITERATIVE TRAVERSALS ---
    public void iterativeInorder() {
        Stack<BSTNode> stack = new Stack<>();
        BSTNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    public void iterativePreorder() {
        if (root == null) return;
        Stack<BSTNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BSTNode node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public void iterativePostorder() {
        if (root == null) return;
        Stack<BSTNode> s1 = new Stack<>();
        Stack<BSTNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            BSTNode node = s1.pop();
            s2.push(node);
            if (node.left != null) s1.push(node.left);
            if (node.right != null) s1.push(node.right);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    public static void main(String[] args) {
        BSTMain bst = new BSTMain();
        int[] values = {5, 3, 1, 4, 7, 2, 6, 8, 9, 0};
        
        for (int val : values) bst.insert(val);

        System.out.println("Inorder (Recursive):"); bst.recursiveInorder(bst.root);
        System.out.println("\nInorder (Iterative):"); bst.iterativeInorder();

        System.out.println("\n\nPreorder (Recursive):"); bst.recursivePreorder(bst.root);
        System.out.println("\nPreorder (Iterative):"); bst.iterativePreorder();

        System.out.println("\n\nPostorder (Recursive):"); bst.recursivePostorder(bst.root);
        System.out.println("\nPostorder (Iterative):"); bst.iterativePostorder();
    }
}
