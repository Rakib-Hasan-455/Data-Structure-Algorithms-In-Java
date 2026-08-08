package Lower_Upper_Binary_Search;

import java.util.Arrays;

public class LowerUpperBoundBinarySearch {
    // implement lower and upper bound binary search
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5};
        int target = 3;
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);
        int lowerBound = lowerBound(arr, target, 0, arr.length - 1);
        System.out.println("LowerBound: " + lowerBound + " Value: " + arr[lowerBound]);
        int upperBound = upperBound(arr, target, 0, arr.length - 1);
        System.out.println("UpperBound: " + upperBound + " Value: " + arr[upperBound]);
    }
}
