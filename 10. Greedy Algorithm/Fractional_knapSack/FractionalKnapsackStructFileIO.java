import java.util.*;

class Item3D {
    double weight, price, unitPrice;
    int itemName;
}

public class FractionalKnapsackStructFileIO {
    public static void main(String[] args) throws Exception {
        System.setIn(new java.io.FileInputStream("input-1.txt"));
        System.setOut(new java.io.PrintStream("output.txt"));

        Scanner sc = new Scanner(System.in);
        int tItems = sc.nextInt();
        double weight = sc.nextDouble();
        Item3D[] arr = new Item3D[tItems];
        for (int i = 0; i < tItems; i++) {
            arr[i] = new Item3D();
            arr[i].itemName = i + 1;
            arr[i].weight = sc.nextDouble();
            arr[i].price = sc.nextDouble();
            arr[i].unitPrice = arr[i].price / arr[i].weight;
        }

        Arrays.sort(arr, (a, b) -> Double.compare(b.unitPrice, a.unitPrice));

        double maxProfit = 0;
        System.out.println("Picking sequence: ");
        for (int i = 0; i < tItems; i++) {
            if (weight != 0) {
                if (weight > arr[i].weight) {
                    maxProfit = maxProfit + arr[i].price;
                    weight = weight - arr[i].weight;
                    System.out.println("Item - " + arr[i].itemName + ":" + arr[i].weight + " = " + arr[i].price);
                } else {
                    maxProfit = maxProfit + weight * arr[i].unitPrice;
                    System.out.println("Item - " + arr[i].itemName + ":" + weight + " = " + weight * arr[i].unitPrice);
                    weight = 0;
                }
            }
        }
        System.out.println("Max Profit: " + maxProfit);
        sc.close();
    }
}