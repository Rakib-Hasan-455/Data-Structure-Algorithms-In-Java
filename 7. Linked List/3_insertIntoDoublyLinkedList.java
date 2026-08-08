// Md. Rakibul Hasan
// 2020000000144

class DoublyNode {
    DoublyNode prev;
    int data;
    DoublyNode next;

    DoublyNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class InsertIntoDoublyLinkedList {

    static DoublyNode head;

    static DoublyNode createNode(int x) {
        return new DoublyNode(x);
    }

    static void insertAtHead(int x) {
        DoublyNode newnode = createNode(x);
        if (head == null) {
            head = newnode;
        } else {
            head.prev = newnode;
            newnode.next = head;
            head = newnode;
        }
    }

    static void insertAtTail(int x) {
        DoublyNode temp = head;
        DoublyNode newnode = createNode(x);
        if (head == null) {
            head = newnode;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
        newnode.prev = temp;
    }

    static void printForward() {
        DoublyNode temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void printBackward() {
        DoublyNode temp = head;
        if (temp == null) {
            return;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            System.out.print("Backward: ");
            while (temp != null) {
                System.out.print(temp.data + "  ");
                temp = temp.prev;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        head = null;
        insertAtHead(2);
        insertAtHead(4);
        insertAtTail(7);

        printForward();
        printBackward();
    }
}