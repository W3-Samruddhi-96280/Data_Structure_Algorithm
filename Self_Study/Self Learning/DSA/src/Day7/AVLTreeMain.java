package Day7;

class AVLNode {
    int data, height;
    AVLNode left, right;

    public AVLNode(int val) {
        data = val;
        height = 1;
    }
}

public class AVLTreeMain {
    private AVLNode root;

    // Get height of a node
    int height(AVLNode n) {
        return (n == null) ? 0 : n.height;
    }

    // Get Balance Factor
    int getBalance(AVLNode n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    // 1. Right Rotate (used for LL Case)
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    // 2. Left Rotate (used for RR Case)
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private AVLNode insertRec(AVLNode node, int key) {
        // Standard BST Insertion
        if (node == null) return new AVLNode(key);
        if (key < node.data) node.left = insertRec(node.left, key);
        else if (key > node.data) node.right = insertRec(node.right, key);
        else return node; // Duplicate keys not allowed

        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get balance factor to check if it became unbalanced
        int balance = getBalance(node);

        // LL Case
        if (balance > 1 && key < node.left.data) return rightRotate(node);

        // RR Case
        if (balance < -1 && key > node.right.data) return leftRotate(node);

        // LR Case
        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL Case
        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " (BF: " + getBalance(node) + ") ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTreeMain tree = new AVLTreeMain();
        
        // This sequence would normally create a skewed BST (linked list)
        // But AVL will balance it using rotations.
        int[] vals = {10, 20, 30, 40, 50, 25};
        for (int v : vals) tree.insert(v);

        System.out.println("Inorder traversal of balanced AVL tree:");
        tree.inorder(tree.root);
    }
}
