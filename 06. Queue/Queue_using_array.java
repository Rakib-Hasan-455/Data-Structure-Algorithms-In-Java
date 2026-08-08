public class Queue_using_array {

    static int[] queue = new int[5];
    static int front = 0;
    static int rear = -1;

    static void enqueue(int value) {
        if (rear == queue.length - 1) {
            System.out.println("Queue is full");
            return;
        }
        queue[++rear] = value;
    }

    static int dequeue() {
        if (front > rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front++];
    }

    static int peek() {
        if (front > rear) return -1;
        return queue[front];
    }

    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);

        System.out.println(dequeue()); // 10
        System.out.println(peek());    // 20
        System.out.println(dequeue()); // 20
        System.out.println(isEmpty()); // false
    }

    static boolean isEmpty() {
        return front > rear;
    }
}