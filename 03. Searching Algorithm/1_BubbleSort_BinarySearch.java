import java.util.Scanner;

class BubbleSortBinarySearch {
    static void bubbleSort(int[] arr, int len) {
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.print("Sorted array: ");
        for (int k = 0; k < len; k++) {
            System.out.print(arr[k]);
            if (k < len - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    static int binarySearchProcess(int[] arr, int search, int lowerbound, int higherbound) {
        while (lowerbound <= higherbound) {
            int midPoint = lowerbound + (higherbound - lowerbound) / 2;
            if (arr[midPoint] == search) {
                return midPoint;
            } else if (search > arr[midPoint]) {
                lowerbound = midPoint + 1;
            } else {
                higherbound = midPoint - 1;
            }
        }
        return -1;
    }

    static void binarySearch(int[] arr, int search, int lowerbound, int higherbound) {
        int indexFound = binarySearchProcess(arr, search, lowerbound, higherbound);
        if (indexFound != -1) {
            System.out.println("Search key found and index is " + indexFound);
        } else {
            System.out.println("Search key not found!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements you wanna input?");
        int len = sc.nextInt();
        int[] arr = new int[len];
        System.out.print("Sample input: ");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Search key: ");
        int search = sc.nextInt();
        bubbleSort(arr, len);
        binarySearch(arr, search, 0, len - 1);
        sc.close();
    }
}