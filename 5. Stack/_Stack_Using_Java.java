import java.util.*;

public class _Stack_Using_Java {
    // Implement stack using Stack of Java
    public static void main(String[] args) {
        Stack<Integer> stack = new java.util.Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }

}
