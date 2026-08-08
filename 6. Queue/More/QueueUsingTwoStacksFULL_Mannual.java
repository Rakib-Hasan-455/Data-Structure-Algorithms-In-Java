package More;//Md. Rakibul Hasan
//2020000000144

public class QueueUsingTwoStacksFULL_Mannual {

    static final int capacity = 100;
    static int top1 = -1;
    static int[] Stack1 = new int[capacity];
    static int top2 = -1;
    static int[] Stack2 = new int[capacity];

    static void Push1(int x) {
        if (top1 == capacity - 1) {
            System.out.println("Stack Overflow on stack 1!");
            return;
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

    static void Push2(int x) {
        if (top2 == capacity - 1) {
            System.out.println("Stack Overflow on Stack 2!");
            return;
        }
        Stack2[++top2] = x;
    }

    static int Pop2() {
        if (top2 == -1) {
            System.out.println("Empty Stack 2!");
            return 0;
        }
        return Stack2[top2--];
    }

    static void enQueue(int x) {
        while (top1 != -1) {
            Push2(Stack1[top1]);
            Pop1();
        }
        Push1(x);
        while (top2 != -1) {
            Push1(Stack2[top2]);
            Pop2();
        }
    }

    static int deQueue() {
        if (top1 == -1) {
            System.out.println("Can't deQueue! Stack1 is Empty.");
            return 0;
        } else {
            int poppedValue = Stack1[top1];
            Pop1();
            return poppedValue;
        }
    }

    static void print() {
        int tempTop1 = top1;
        while (tempTop1 != -1) {
            System.out.println(Stack1[tempTop1]);
            tempTop1--;
        }
    }

    public static void main(String[] args) {
        enQueue(1);
        enQueue(2);
        enQueue(3);
        deQueue();
        enQueue(4);
        System.out.println("Latest Queue elements are:");
        print();
    }
}