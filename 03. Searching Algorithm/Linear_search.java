import java.util.Scanner;

public class Linear_search {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                System.out.println("Found");
            }
        }
        sc.close();
    }
}