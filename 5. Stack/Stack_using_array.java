import java.util.Scanner;

public class Stack_using_array {

    static final int capacity = 10;
    static int top = -1;
    static int[] stackArr = new int[capacity];

    static void Push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stackArr[++top] = x;
    }

    static void Pop() {
        if (top == -1) {
            System.out.println("No element to the pop");
            return;
        }
        top--;
    }

    static void print() {
        for (int i = 0; i <= top; i++) {
            System.out.println(stackArr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = capacity;
        for (int i = 0; i < len; i++) {
            int x = sc.nextInt();
            Push(x);
        }
        Pop();
        print();
        System.out.println(stackArr[top]);
        sc.close();
    }
}