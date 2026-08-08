import java.util.Scanner;

class MargeSort {
    static void mergeAccend(int[] arr, int lo, int mid, int hi) {
        int[] temp = new int[100];
        int k = 0, i = lo, j = mid + 1;
        while (i <= mid && j <= hi) {
            if (arr[i] < arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= hi) temp[k++] = arr[j++];
        for (i = lo, k = 0; i <= hi; i++, k++) arr[i] = temp[k];
    }

    static void mergeSortAccend(int[] arr, int lo, int hi) {
        if (lo == hi) return;
        int mid = (lo + hi) / 2;
        mergeSortAccend(arr, lo, mid);
        mergeSortAccend(arr, mid + 1, hi);
        mergeAccend(arr, lo, mid, hi);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        mergeSortAccend(arr, 0, n - 1);
        for (int v : arr) System.out.println(v);
        sc.close();
    }
}