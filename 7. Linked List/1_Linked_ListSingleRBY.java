// Created by Rakib on 4/25/2021.

class Node {
    int data;
    NodeDjstra link;

    Node(int data) {
        this.data = data;
        this.link = null;
    }
}

class Linked_ListSingleRBY {

    static void print(NodeDjstra next) {
        while (next != null) {
            System.out.println(next.data);
            System.out.println(next.link);
            next = next.link;
        }
    }

    public static void main(String[] args) {
        NodeDjstra head = new NodeDjstra(2);
        NodeDjstra two = new NodeDjstra(5);
        NodeDjstra three = new NodeDjstra(8);

        head.link = two;
        two.link = three;
        three.link = null;

        print(head);
    }
}