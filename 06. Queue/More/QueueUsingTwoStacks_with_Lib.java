package More;// CPP program to implement Queue using
// two stacks with costly enQueue()

import java.util.Stack;

class QueueUsingStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void enQueue(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    int deQueue() {
        if (s1.isEmpty()) {
            System.out.println("Q is Empty");
            System.exit(0);
        }
        return s1.pop();
    }
}

public class QueueUsingTwoStacks_with_Lib {

    static void display(Stack<Integer> s1) {
        Stack<Integer> s3 = new Stack<>();
        s3.addAll(s1);
        while (!s3.isEmpty()) {
            System.out.println(s3.pop());
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        display(q.s1);
    }
}