import java.util.LinkedList;
import java.util.Queue;

class MinMaxBSTNode {
    int data;
    MinMaxBSTNode left;
    MinMaxBSTNode right;

    MinMaxBSTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class FindMinMaxInBST {

    static MinMaxBSTNode createNode(int data) {
        return new MinMaxBSTNode(data);
    }

    static MinMaxBSTNode Insert(MinMaxBSTNode root, int Data) {
        if (root == null) {
            root = createNode(Data);
            return root;
        } else if (root.data >= Data) {
            root.left = Insert(root.left, Data);
        } else {
            root.right = Insert(root.right, Data);
        }
        return root;
    }

    static int findMin(MinMaxBSTNode root) {
        if (root == null) {
            System.out.println("Error: Tree is empty!");
            return -1;
        } else {
            MinMaxBSTNode current = root;
            while (current.left != null) {
                current = current.left;
            }
            return current.data;
        }
    }

    static int findMax(MinMaxBSTNode root) {
        if (root == null) {
            System.out.println("Error: Tree is empty!");
            return -1;
        } else {
            MinMaxBSTNode current = root;
            while (current.right != null) {
                current = current.right;
            }
            return current.data;
        }
    }

    static void levelOrderPrint(MinMaxBSTNode root) {
        if (root == null) {
            return;
        }
        Queue<MinMaxBSTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            MinMaxBSTNode current = q.poll();
            System.out.print(current.data + " ");
            if (current.left != null) {
                q.add(current.left);
            }
            if (current.right != null) {
                q.add(current.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinMaxBSTNode root = null;
        root = Insert(root, 15);
        root = Insert(root, 9);
        root = Insert(root, 16);
        root = Insert(root, 5);
        root = Insert(root, 25);
        root = Insert(root, 21);
        root = Insert(root, 27);
        root = Insert(root, 3);
        levelOrderPrint(root);

        System.out.println("Minimum : " + findMin(root));
        System.out.println("Maximum : " + findMax(root));
    }
}