import java.util.*;

class Items {
    double w, p, perPrice;
}

public class Greedy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double w = sc.nextDouble();
        double mProfit = 0;
        Items[] item = new Items[n];
        for (int i = 0; i < n; i++) {
            item[i] = new Items();
            item[i].w = sc.nextDouble();
            item[i].p = sc.nextDouble();
            item[i].perPrice = item[i].p / item[i].w;
        }

        Arrays.sort(item, (a, b) -> Double.compare(b.perPrice, a.perPrice));

        for (int i = 0; i < n; i++) {
            if (w > item[i].w) {
                mProfit = mProfit + item[i].p;
                w = w - item[i].w;
                System.out.println("Item - " + item[i].w + " =" + item[i].p);
            } else {
                mProfit = mProfit + w * item[i].perPrice;
                System.out.println("Item - " + w + " =" + w * item[i].perPrice);
                w = 0;
                break;
            }
        }
        System.out.println("Profit:" + mProfit);
        sc.close();
    }
}