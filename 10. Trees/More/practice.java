/* Deleting a Node from Binary search tree */
import java.util.LinkedList;
import java.util.Queue;

class BSTDeleteNode {
    int data;
    BSTDeleteNode left;
    BSTDeleteNode right;

    BSTDeleteNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class practice {

    static BSTDeleteNode FindMin(BSTDeleteNode root) {
        while (root.left != null) root = root.left;
        return root;
    }

    static BSTDeleteNode Delete(BSTDeleteNode root, int data) {
        if (root == null) return root;
        else if (data < root.data) root.left = Delete(root.left, data);
        else if (data > root.data) root.right = Delete(root.right, data);
        else {
            // Case 1: No child
            if (root.left == null && root.right == null) {
                root = null;
            }
            // Case 2: One child
            else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }
            // Case 3: 2 children
            else {
                BSTDeleteNode temp = FindMin(root.right);
                root.data = temp.data;
                root.right = Delete(root.right, temp.data);
            }
        }
        return root;
    }

    static BSTDeleteNode Insert(BSTDeleteNode root, int data) {
        if (root == null) {
            root = new BSTDeleteNode(data);
        } else if (data <= root.data) {
            root.left = Insert(root.left, data);
        } else {
            root.right = Insert(root.right, data);
        }
        return root;
    }

    static void levelOrderPrint(BSTDeleteNode root) {
        if (root == null) {
            return;
        }
        Queue<BSTDeleteNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BSTDeleteNode current = q.poll();
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
        BSTDeleteNode root = null;
        root = Insert(root, 5);
        root = Insert(root, 10);
        root = Insert(root, 3);
        root = Insert(root, 4);
        root = Insert(root, 1);
        root = Insert(root, 11);

        Delete(root, 17);
        System.out.print("Levelorder: ");
        levelOrderPrint(root);
        System.out.println();
    }
}