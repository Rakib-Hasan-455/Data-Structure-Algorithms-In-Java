public class MergeSort {
    // implementation of MergeSort
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 2, 5, 9, 7};
        mergesort(arr, 0, arr.length - 1);
        System.out.println(java.util.Arrays.toString(arr));
    }
    
    public static void mergesort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergesort(arr, low, mid);
            mergesort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(arr, low, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
