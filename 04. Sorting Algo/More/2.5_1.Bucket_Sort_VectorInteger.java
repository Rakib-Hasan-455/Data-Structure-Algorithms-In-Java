package More;

import java.util.*;

class BucketSortVectorInteger {
    static void display(int[] arr) {
        for (int v : arr) System.out.print(v + " ");
        System.out.println();
    }

    static void bucketSort(int[] arr, int size) {
        int max = Arrays.stream(arr).max().getAsInt();
        int bucket = 10;
        int divider = (int) Math.ceil((float) (max + 1) / bucket);

        ArrayList<Integer>[] B = new ArrayList[bucket];
        for (int i = 0; i < bucket; i++) B[i] = new ArrayList<>();

        for (int v : arr) {
            int j = (int) Math.floor((float) v / divider);
            B[j].add(v);
        }
        for (int i = 0; i < bucket; i++) Collections.sort(B[i]);

        int k = 0;
        for (int i = 0; i < bucket; i++)
            for (int j = 0; j < B[i].size(); j++)
                arr[k++] = B[i].get(j);
    }

    public static void main(String[] args) {
        int[] arr = {22, 45, 12, 8, 10, 6, 72, 81, 33, 18, 50, 14};
        display(arr);
        bucketSort(arr, arr.length);
        display(arr);
    }
}