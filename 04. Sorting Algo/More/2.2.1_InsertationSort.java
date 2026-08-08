package More;

import java.util.Scanner;

class InsertationSort {
    static void insertion_sort(int[] array, int n) {
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        insertion_sort(a, n);
        for (int i = 0; i < n; i++) System.out.print(a[i] + "\t");
        sc.close();
    }
}