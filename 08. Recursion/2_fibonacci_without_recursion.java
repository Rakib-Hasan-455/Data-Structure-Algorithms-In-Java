import java.util.Scanner;

class FibonacciWithoutRecursion {

    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int fiboprev = 0;
        int fibonext = 1;
        System.out.print("fibonacci = ");
        for (int i = 2; i <= n; i++) {
            int temp = fibonext;
            System.out.print(fibonext + "\t");
            fibonext = fibonext + fiboprev;
            fiboprev = temp;
        }
        System.out.println();
        return fibonext;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lastFibo = fibonacci(n);
        System.out.println("Last fibonacci = " + lastFibo);
        sc.close();
    }
}