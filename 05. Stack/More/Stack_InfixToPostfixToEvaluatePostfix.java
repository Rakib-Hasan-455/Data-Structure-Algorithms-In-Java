package More;//Md. Rakibul Hasan
//2020000000144

import java.util.Scanner;

public class Stack_InfixToPostfixToEvaluatePostfix {

    static final int capacity = 100;
    static int top1 = -1;
    static char[] Stack1 = new char[capacity];
    static int top2 = -1;
    static int[] Stack2 = new int[capacity];

    static String infix, postfix = "";
    static int point1 = 0, point2 = 0;

    static void Push1(char x) {
        if (top1 == capacity - 1) {
            System.out.println("Stack Overflow on stack 1!");
            return;
        }
        Stack1[++top1] = x;
    }

    static char Pop1() {
        if (top1 == -1) {
            return (char) -1;
        } else {
            return Stack1[top1--];
        }
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
            return -1;
        } else {
            return Stack2[top2--];
        }
    }

    static int precedence(char a) {
        if (a == '(') {
            return 0;
        } else if (a == '+' || a == '-') {
            return 1;
        } else if (a == '*' || a == '/') {
            return 2;
        } else if (a == '^') {
            return 3;
        }
        return 0;
    }

    static String infixToPostfix() {
        while (point1 < infix.length()) {
            if (Character.isLetterOrDigit(infix.charAt(point1))) {
                postfix += infix.charAt(point1);
            } else if (infix.charAt(point1) == '(') {
                Push1(infix.charAt(point1));
            } else if (infix.charAt(point1) == ')') {
                char b;
                while ((b = Pop1()) != '(') {
                    postfix += b;
                }
            } else {
                while (top1 != -1 && precedence(Stack1[top1]) >= precedence(infix.charAt(point1))) {
                    postfix += Pop1();
                }
                Push1(infix.charAt(point1));
            }
            point1++;
        }

        while (top1 > -1) {
            postfix += Pop1();
        }
        return postfix;
    }

    static int postfixEvaluation() {
        Scanner sc = new Scanner(System.in);
        while (point2 < postfix.length()) {
            char c = postfix.charAt(point2);
            if (c >= '0' && c <= '9') {
                int z = c - '0';
                Push2(z);
            } else if (c >= 'A' && c <= 'z' && c != '^') {
                System.out.print("Enter the value of " + c + "=");
                int z = sc.nextInt();
                Push2(z);
            } else if (c == '+') {
                int x = Pop2();
                int y = Pop2();
                int z = y + x;
                Push2(z);
            } else if (c == '-') {
                int x = Pop2();
                int y = Pop2();
                int z = y - x;
                Push2(z);
            } else if (c == '*') {
                int x = Pop2();
                int y = Pop2();
                int z = y * x;
                Push2(z);
            } else if (c == '/') {
                int x = Pop2();
                int y = Pop2();
                int z = y / x;
                Push2(z);
            } else if (c == '^') {
                int x = Pop2();
                int y = Pop2();
                int z = (int) Math.pow(y, x);
                Push2(z);
            } else {
                System.out.println("Invalid Expression! Please fix infix expression and try again.");
                break;
            }
            point2++;
        }
        sc.close();
        return Pop2();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Infix expression = ");
        infix = sc.nextLine();
        postfix = infixToPostfix();
        System.out.println("Postfix expression = " + postfix);
        int result = postfixEvaluation();
        System.out.println("Postfix Evaluation Result = " + result);
        sc.close();
    }
}