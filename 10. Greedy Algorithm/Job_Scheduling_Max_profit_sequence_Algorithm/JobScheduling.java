import java.util.*;

class Map3D {
    char id;
    int deadline, profit;
}

public class JobScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tJob = sc.nextInt();
        Map3D[] arr = new Map3D[tJob];

        for (int i = 0; i < tJob; i++) {
            arr[i] = new Map3D();
            arr[i].id = sc.next().charAt(0);
            arr[i].deadline = sc.nextInt();
            arr[i].profit = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(b.profit, a.profit));

        int[] result = new int[tJob];
        boolean[] slot = new boolean[tJob];
        int profit = 0;

        for (int i = 0; i < tJob; i++) {
            slot[i] = false;
        }
        System.out.println("\nSorted 3D data:");
        for (int i = 0; i < tJob; i++) {
            System.out.println(arr[i].id + " " + arr[i].deadline + " " + arr[i].profit);
            for (int j = arr[i].deadline; j > 0; j--) {
                if (!slot[j]) {
                    result[j] = i;
                    slot[j] = true;
                    profit += arr[i].profit;
                    break;
                }
            }
        }
        System.out.println("\nSequenced Result: ");
        for (int i = 0; i < tJob; i++) {
            if (slot[i]) {
                System.out.println(arr[result[i]].id + " " + arr[result[i]].deadline + " " + arr[result[i]].profit);
            }
        }
        System.out.println("Total Profit: " + profit);
        sc.close();
    }
}