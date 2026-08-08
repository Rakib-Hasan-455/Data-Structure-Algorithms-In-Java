import java.util.Scanner;

class QuickSortAdvanced {
    static void quickSortAccend(int[] array, int low, int high) {
        int i = low, j = high;
        int pivot = array[(i + j) / 2];
        while (i <= j) {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (j > low) quickSortAccend(array, low, j);
        if (i < high) quickSortAccend(array, i, high);
    }

    static void quickSortDecend(int[] array, int low, int high) {
        int i = low, j = high;
        int pivot = array[(i + j) / 2];
        while (i <= j) {
            while (array[i] > pivot) i++;
            while (array[j] < pivot) j--;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (j > low) quickSortDecend(array, low, j);
        if (i < high) quickSortDecend(array, i, high);
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