import java.util.*;

class BucketSortVectorDecimal {
    static void bucketSort(float[] arr, int n) {
        ArrayList<Float>[] b = new ArrayList[n];
        for (int i = 0; i < n; i++) b[i] = new ArrayList<>();

        for (float v : arr) {
            int bi = (int) (n * v);
            b[bi].add(v);
        }
        for (int i = 0; i < n; i++) Collections.sort(b[i]);

        int index = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < b[i].size(); j++)
                arr[index++] = b[i].get(j);
    }

    public static void main(String[] args) {
        float[] arr = {0.897f, 0.896f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
        bucketSort(arr, arr.length);
        System.out.println("Sorted array is ");
        for (float v : arr) System.out.print(v + " ");
    }
}