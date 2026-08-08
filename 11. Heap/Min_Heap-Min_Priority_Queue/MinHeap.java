import java.util.Scanner;

class MinHeap {
    static final int NN = 100;
    int[] myarray = new int[NN + 1];
    int n = 0;

    void insert(int K) {
        if (n == NN) {
            System.out.println("cannot insert any more element, the heap is full");
            return;
        }
        ++n;
        myarray[n] = K;
        System.out.println("Inserted: " + myarray[n]);
        int p = n;
        while (p > 1) {
            int pr = p / 2;
            if (myarray[pr] > myarray[p]) {
                int temp = myarray[pr];
                myarray[pr] = myarray[p];
                myarray[p] = temp;
                p = pr;
            } else break;
        }
    }

    int remove() {
        if (n == 0) {
            System.out.println("The heap is empty, cannot delete.");
            return -1;
        }
        int K = myarray[1];
        myarray[1] = myarray[n];
        n = n - 1;
        int p = 1;
        while (2 * p <= n) {
            int ch = 2 * p;
            if (2 * p + 1 <= n) {
                if (myarray[ch] > myarray[ch + 1])
                    ch++;
            }
            if (myarray[p] > myarray[ch]) {
                int temp = myarray[p];
                myarray[p] = myarray[ch];
                myarray[ch] = temp;
                p = ch;
            } else break;
        }
        return K;
    }

    void print() {
        System.out.print("Current nodes: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(myarray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap A = new MinHeap();
        A.insert(1);
        A.insert(2);
        A.insert(3);
        A.insert(4);
        A.print();
        A.remove();
        A.print();
        A.remove();
        A.print();
    }
}