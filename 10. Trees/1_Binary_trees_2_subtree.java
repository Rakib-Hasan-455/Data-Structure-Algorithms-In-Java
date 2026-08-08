import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode2 {
    int data;
    BinaryTreeNode2 left;
    BinaryTreeNode2 right;

    BinaryTreeNode2(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTrees2Subtree {

    static BinaryTreeNode2 createNode(int data) {
        return new BinaryTreeNode2(data);
    }

    static BinaryTreeNode2 insertLeft(BinaryTreeNode2 root, int data) {
        root.left = createNode(data);
        return root.left;
    }

    static BinaryTreeNode2 insertRight(BinaryTreeNode2 root, int data) {
        root.right = createNode(data);
        return root.right;
    }

    static void levelOrderPrint(BinaryTreeNode2 root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode2> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BinaryTreeNode2 current = q.poll();
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
        BinaryTreeNode2 root = createNode(15);

        insertLeft(root, 10);
        insertRight(root, 20);

        insertLeft(root.left, 9);
        insertRight(root.left, 11);

        insertLeft(root.right, 19);
        insertRight(root.right, 21);

        levelOrderPrint(root);
    }
}