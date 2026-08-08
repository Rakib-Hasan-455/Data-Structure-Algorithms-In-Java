import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTrees {

    static BinaryTreeNode createNode(int data) {
        return new BinaryTreeNode(data);
    }

    static BinaryTreeNode insertLeft(BinaryTreeNode root, int data) {
        root.left = createNode(data);
        return root.left;
    }

    static BinaryTreeNode insertRight(BinaryTreeNode root, int data) {
        root.right = createNode(data);
        return root.right;
    }

    static void levelOrderPrint(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BinaryTreeNode current = q.poll();
            System.out.print(current.data + " ");
            if (current.left != null) {
                q.add(current.left);
            }
            if (current.right != null) {
                q.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = createNode(15);

        insertLeft(root, 10);
        insertRight(root, 20);

        insertLeft(root.left, 9);
        insertRight(root.left, 11);

        insertLeft(root.right, 19);
        insertRight(root.right, 21);

        levelOrderPrint(root);
    }
}