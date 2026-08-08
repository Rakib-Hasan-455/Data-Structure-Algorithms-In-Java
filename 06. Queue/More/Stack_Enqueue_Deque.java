package More;

import java.util.Scanner;

class QueueStack_Enqueue_Deque {

    static char[] stack = new char[100];
    static int top = -1;

    static void push(char x) {
        stack[++top] = x;
    }

    static char pop() {
        if (top == -1)
            return (char) -1;
        else
            return stack[top--];
    }

    static int priority(char x) {
        if (x == '(')
            return 0;
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/')
            return 2;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the expression : ");
        String exp = sc.nextLine();

        for (int i = 0; i < exp.length(); i++) {
            char e = exp.charAt(i);
            if (Character.isLetterOrDigit(e))
                System.out.print(e);
            else if (e == '(')
                push(e);
            else if (e == ')') {
                char x;
                while ((x = pop()) != '(')
                    System.out.print(x);
            } else {
                while (top != -1 && priority(stack[top]) >= priority(e))
                    System.out.print(pop());
                push(e);
            }
        }

        while (top != -1) {
            System.out.print(pop());
        }
        sc.close();
    }
}