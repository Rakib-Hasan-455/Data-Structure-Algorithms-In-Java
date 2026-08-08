// Counting sort in Java programming

class CountingSort {
    static void countSort(int[] array, int size) {
        int[] output = new int[10];
        int[] count = new int[10];
        int max = array[0];

        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }

        for (int i = 0; i <= max; ++i) {
            count[i] = 0;
        }

        for (int i = 0; i < size; i++) {
            count[array[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < size - 1; i++) {
            output[count[array[i]] + 1] = array[i];
            count[array[i]]--;
        }

        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }

    static void printArray(int[] array, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        int n = array.length;
        countSort(array, n);
        printArray(array, n);
    }
}