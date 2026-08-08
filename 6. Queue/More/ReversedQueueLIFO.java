package More;//Md. Rakibul Hasan
//2020000000144

class ReversedQueueLIFO {

    static final int capacity = 100;
    static int top1 = -1;
    static int[] Stack1 = new int[capacity];

    static void Push1(int x) {
        if (top1 == capacity - 1) {
            System.out.println("Stack Overflow on stack 1!");
        }
        Stack1[++top1] = x;
    }

    static int Pop1() {
        if (top1 == -1) {
            System.out.println("Empty Stack 1!");
            return 0;
        }
        return Stack1[top1--];
    }

    static void enQueue(int x) {
        Push1(x);
    }

    static int deQueue() {
        if (top1 == -1) {
            System.out.println("Can't deQueue! Stack1 is already Empty.");
            return 0;
        } else {
            return Pop1();
        }
    }

    static void print() {
        int tempTop1 = 0;
        while (tempTop1 <= top1) {
            System.out.println(Stack1[tempTop1]);
            tempTop1++;
        }
    }

    public static void main(String[] args) {
        enQueue(1);
        enQueue(2);
        enQueue(3);
        enQueue(4);
        deQueue();
        enQueue(5);
        System.out.println("Reversed Queue elements are:");
        print();
    }
}