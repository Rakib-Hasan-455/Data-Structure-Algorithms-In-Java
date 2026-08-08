import java.util.LinkedList;
import java.util.Queue;

class ThreeSubtreeNode {
    int data;
    ThreeSubtreeNode first;
    ThreeSubtreeNode middle;
    ThreeSubtreeNode last;

    ThreeSubtreeNode(int data) {
        this.data = data;
        this.first = null;
        this.middle = null;
        this.last = null;
    }
}

class TreeUsing3Subtree {

    static ThreeSubtreeNode createNode(int Data) {
        return new ThreeSubtreeNode(Data);
    }

    static ThreeSubtreeNode insertFirst(ThreeSubtreeNode root, int Data) {
        root.first = createNode(Data);
        return root.first;
    }

    static ThreeSubtreeNode insertMiddle(ThreeSubtreeNode root, int Data) {
        root.middle = createNode(Data);
        return root.middle;
    }

    static ThreeSubtreeNode insertLast(ThreeSubtreeNode root, int Data) {
        root.last = createNode(Data);
        return root.last;
    }

    static void levelOrderPrint(ThreeSubtreeNode root) {
        if (root == null) {
            return;
        }
        Queue<ThreeSubtreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            ThreeSubtreeNode current = q.poll();
            System.out.print(current.data + " ");
            if (current.first != null) {
                q.add(current.first);
            }
            if (current.middle != null) {
                q.add(current.middle);
            }
            if (current.last != null) {
                q.add(current.last);
            }
        }
    }

    public static void main(String[] args) {
        ThreeSubtreeNode root = createNode(1);

        insertFirst(root, 2);
        insertMiddle(root, 3);
        insertLast(root, 5);

        insertFirst(root.first, 7);
        insertMiddle(root.first, 1);
        insertLast(root.first, 8);

        insertFirst(root.middle, 6);
        insertMiddle(root.middle, 1);
        insertLast(root.middle, 7);

        insertFirst(root.last, 8);
        insertMiddle(root.last, 9);
        insertLast(root.last, 5);

        System.out.println("Output:");
        levelOrderPrint(root);
    }
}