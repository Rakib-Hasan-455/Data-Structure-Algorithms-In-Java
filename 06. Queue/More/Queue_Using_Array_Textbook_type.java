package More;

public class Queue_Using_Array_Textbook_type {

    static final int size = 100;
    static int[] queue = new int[size];
    static int front = -1;
    static int rear = -1;

    static void Enqueue(int x) {
        if (rear == size - 1) {
            System.out.println("Overflow was controlled");
        } else if (front == -1 && rear == -1) {
            front = rear = 0;
            queue[rear] = x;
        } else {
            rear++;
            queue[rear] = x;
        }
        System.out.println(rear);
        System.out.println(front);
    }

    static void Dequeue() {
        if (front == -1 && rear == -1) {
            System.out.println("Empty. Cant delete");
        } else if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
        System.out.println(rear);
        System.out.println(front);
    }

    static void Display() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is Empty");
        } else {
            for (int i = front; i < rear + 1; i++) {
                System.out.println(queue[i]);
            }
        }
    }

    public static void main(String[] args) {
        Enqueue(5);
        System.out.println("\n");
        Enqueue(6);
        System.out.println("\n");
        Enqueue(9);
        System.out.println("\n");
        Enqueue(5);
        System.out.println("\n");
        Enqueue(6);
        System.out.println("\n");
        Enqueue(9);
        System.out.println("\n");
        Dequeue();
        System.out.println("\n");
        Enqueue(3);
        System.out.println("\n");
        Dequeue();
        System.out.println("\n");
    }
}