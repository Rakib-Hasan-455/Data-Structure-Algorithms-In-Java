import java.util.Scanner;

class FibonacciWithRecursion {

    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lastFibo = fibonacci(n);
        System.out.println("Last fibonacci = " + lastFibo);
        sc.close();
    }
}