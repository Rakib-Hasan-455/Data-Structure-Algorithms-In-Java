// Created by Rakib on 5/9/2021.

class SinglyNode {
    int data;
    SinglyNode next;

    SinglyNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Insert_into_single_linked_list {

    static SinglyNode head, point;

    static void insert(int x) {
        SinglyNode temp = new SinglyNode(x);
        if (head == null) {
            head = temp;
        } else {
            point = head;
            while (point.next != null) {
                point = point.next;
            }
            point.next = temp;
        }
    }

    static void print() {
        SinglyNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        insert(2);
        insert(1);
        insert(3);
        print();
    }
}