import java.util.Scanner;

class ZAssignment {
    static final int NN = 100;
    int[] myarray = new int[NN + 1];
    int n = 0;

    void insert(int K) {
        if (n == NN) {
            System.out.println("cannot insert any more element");
            return;
        }
        ++n;
        myarray[n] = K;
        int p = n;
        while (p > 1) {
            int pr = p / 2;
            if (myarray[pr] < myarray[p]) {
                int temp = myarray[pr];
                myarray[pr] = myarray[p];
                myarray[p] = temp;
                p = pr;
            } else break;
        }
    }

    int remove() {
        if (n == 0) {
            System.out.println("empty cannot delete.");
            return -1;
        }
        int K = myarray[1];
        myarray[1] = myarray[n];
        n = n - 1;
        int p = 1;
        while (2 * p <= n) {
            int ch = 2 * p;
            if (2 * p + 1 <= n) {
                if (myarray[ch] < myarray[ch + 1])
                    ch++;
            }
            if (myarray[p] < myarray[ch]) {
                int temp = myarray[p];
                myarray[p] = myarray[ch];
                myarray[ch] = temp;
                p = ch;
            } else break;
        }
        return K;
    }

    void print() {
        for (int i = 1; i <= n; i++) {
            System.out.print(myarray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ZAssignment A = new ZAssignment();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("1.Insert");
            System.out.println("2.Find");
            System.out.println("3.Delete");
            int option = sc.nextInt();
            if (option == 1) {
                int value = sc.nextInt();
                A.insert(value);
            } else if (option == 2) {
                System.out.println(A.myarray[1]);
            } else if (option == 3) {
                System.out.println(A.remove() + " is deleted!");
            }
        }
        A.print();
        sc.close();
    }
}