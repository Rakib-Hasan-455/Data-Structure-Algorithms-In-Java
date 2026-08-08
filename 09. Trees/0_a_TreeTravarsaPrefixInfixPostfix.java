class TreeNode {
    int item;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.item = value;
        this.left = null;
        this.right = null;
    }
}

class TreeTraversalPrefixInfixPostfix {

    static void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.item + " ->");
        inorderTraversal(root.right);
    }

    static void preorderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.item + " ->");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    static void postorderTraversal(TreeNode root) {
        if (root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.item + " ->");
    }

    static TreeNode createNode(int value) {
        return new TreeNode(value);
    }

    static TreeNode insertLeft(TreeNode root, int value) {
        root.left = createNode(value);
        return root.left;
    }

    static TreeNode insertRight(TreeNode root, int value) {
        root.right = createNode(value);
        return root.right;
    }

    public static void main(String[] args) {
        TreeNode root = createNode(1);
        insertLeft(root, 2);
        insertRight(root, 3);
        insertLeft(root.left, 4);
        insertLeft(root.left.left, 10);
        insertRight(root.right, 5);
        insertRight(root.right.right, 6);
        insertRight(root.right.right.right, 7);

        System.out.println("Inorder traversal");
        inorderTraversal(root);

        System.out.println("\nPreorder traversal");
        preorderTraversal(root);

        System.out.println("\nPostorder traversal");
        postorderTraversal(root);
    }
}