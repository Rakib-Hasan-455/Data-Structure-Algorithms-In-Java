import java.util.Scanner;

class QuickSortCommon {
    static int partitionAC(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return (i + 1);
    }

    static void quickSortAccend(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partitionAC(array, low, high);
            quickSortAccend(array, low, pivot - 1);
            quickSortAccend(array, pivot + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = sc.nextInt();
        quickSortAccend(array, 0, n - 1);
        for (int v : array) System.out.println(v);
        sc.close();
    }
}