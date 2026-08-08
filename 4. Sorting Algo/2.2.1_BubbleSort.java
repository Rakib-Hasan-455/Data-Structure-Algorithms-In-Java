class BubbleSortV2 {
    static void bubblesort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static void print(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 2, 5, 9, 7};
        bubblesort(arr);
        print(arr);
    }
}