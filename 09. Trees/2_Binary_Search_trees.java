import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    BSTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTrees {

    static BSTNode createNode(int data) {
        return new BSTNode(data);
    }

    static BSTNode Insert(BSTNode root, int Data) {
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

    static boolean Search(BSTNode root, int data) {
        if (root == null) {
            return false;
        } else if (root.data == data) {
            return true;
        } else if (data <= root.data) {
            return Search(root.left, data);
        } else {
            return Search(root.right, data);
        }
    }

    static void levelOrderPrint(BSTNode root) {
        if (root == null) {
            return;
        }
        Queue<BSTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BSTNode current = q.poll();
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
        BSTNode root = null;
        root = Insert(root, 15);
        root = Insert(root, 9);
        root = Insert(root, 16);
        root = Insert(root, 5);
        root = Insert(root, 25);
        root = Insert(root, 21);
        root = Insert(root, 27);
        root = Insert(root, 3);
        levelOrderPrint(root);

        Scanner sc = new Scanner(System.in);
        System.out.print("Search Data: ");
        int data = sc.nextInt();

        if (Search(root, data)) {
            System.out.println("Found!");
        } else {
            System.out.println("Not Found!");
        }
        sc.close();
    }
}