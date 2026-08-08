import java.util.Scanner;

public class BinarySearch {

    static int search(int[] arr, int searchVal, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] == searchVal) {
                return middle;
            } else if (arr[middle] > searchVal) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 9, 11};
        Scanner sc = new Scanner(System.in);
        int searchVal = sc.nextInt();
        int result = search(arr, searchVal, 0, arr.length - 1);
        int resRecursion = searchRecursion(arr, searchVal, 0, arr.length - 1);
        if (result == -1 || resRecursion == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.println("Found at index " + result + "!");
            System.out.println("Found at index " + resRecursion + "!");
        }
        sc.close();
    }


    static int searchRecursion(int[] arr, int searchVal, int left, int right) {
        if (left <= right) {
            int middle = (left + right) / 2; // note int mid = left + (right - left) / 2; // for preventing Int overflow
            if (arr[middle] == searchVal) {
                return middle;
            } else if (arr[middle] < searchVal) {
                return searchRecursion(arr, searchVal, middle + 1, right);
            } else {
                return searchRecursion(arr, searchVal, left, middle - 1);
            }
        }
        return -1;
    }

    static int lowerBound(int[] arr, int searchVal, int left, int right) {
        int answer = right + 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (arr[middle] >= searchVal) {
                answer = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return answer;
    }

    static int upperBound(int[] arr, int searchVal, int left, int right) {
        int answer = right + 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] > searchVal) {
                answer = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return answer;
    }

}