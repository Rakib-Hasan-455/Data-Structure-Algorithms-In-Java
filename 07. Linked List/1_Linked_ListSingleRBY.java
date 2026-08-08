// Created by Rakib on 4/25/2021.

class Node {
    int data;
    Node link;

    Node(int data) {
        this.data = data;
        this.link = null;
    }
}

class Linked_ListSingleRBY {

    static void print(Node next) {
        while (next != null) {
            System.out.println(next.data);
            System.out.println(next.link);
            next = next.link;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        Node two = new Node(5);
        Node three = new Node(8);

        head.link = two;
        two.link = three;
        three.link = null;

        print(head);
    }
}