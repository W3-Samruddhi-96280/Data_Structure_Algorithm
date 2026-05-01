package Day6;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}

public class BSTOperations {
    private Node root;

    // Helper to insert nodes
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.data) root.left = insertRec(root.left, key);
        else if (key > root.data) root.right = insertRec(root.right, key);
        return root;
    }

    // 1. DELETE NODE WITH SUCCESSOR REPLACEMENT
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.data) root.left = deleteRec(root.left, key);
        else if (key > root.data) root.right = deleteRec(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: Get In-order Successor (smallest in right subtree)
            root.data = minValue(root.right);

            // Delete the in-order successor
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // 2. TREE PROPERTY CHECKS

    // Full Tree: Every node has 0 or 2 children
    public boolean isFull(Node node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return true;
        if (node.left != null && node.right != null) 
            return isFull(node.left) && isFull(node.right);
        return false;
    }

    // Perfect Tree: All internal nodes have 2 children and leaves are at same level
    public boolean isPerfect(Node node, int depth, int level) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return (depth == level + 1);
        if (node.left == null || node.right == null) return false;
        return isPerfect(node.left, depth, level + 1) && isPerfect(node.right, depth, level + 1);
    }

    // Balanced Tree: Height difference of left and right subtrees is max 1
    public int checkBalanced(Node node) {
        if (node == null) return 0;
        int lh = checkBalanced(node.left);
        if (lh == -1) return -1;
        int rh = checkBalanced(node.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }

    // Complete Tree: All levels filled except possibly the last, which is filled left to right
    public boolean isComplete(Node root) {
        if (root == null) return true;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == null) flag = true;
            else {
                if (flag) return false;
                q.add(temp.left);
                q.add(temp.right);
            }
        }
        return true;
    }

    // Helper for depth
    private int findDepth(Node node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }

    public static void main(String[] args) {
        BSTOperations bst = new BSTOperations();
        int[] vals = {50, 30, 70, 20, 40, 60, 80};
        for (int v : vals) bst.insert(v);

        System.out.println("Full Tree: " + bst.isFull(bst.root));
        System.out.println("Complete Tree: " + bst.isComplete(bst.root));
        System.out.println("Balanced Tree: " + (bst.checkBalanced(bst.root) != -1));
        System.out.println("Perfect Tree: " + bst.isPerfect(bst.root, bst.findDepth(bst.root), 0));

        System.out.println("\nDeleting 50 (Root) and replacing with successor...");
        bst.delete(50);
        
        System.out.println("New Root is likely 60. Operations completed.");
    }
}
