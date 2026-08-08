import java.util.Scanner;

class InterpolationSearchRecursion {
    static int step = 1;

    static int search(int[] arr, int searchKey, int left, int right) {
        if (searchKey > arr[right] || searchKey < arr[left]) {
            return -1;
        }
        if (left <= right) {
            int middle = left + (int) (((double) (right - left) /
                    (arr[right] - arr[left])) * (searchKey - arr[left]));
            System.out.println("Step " + step++ + " Left: " + left + " Right: " + right +
                    " Array left: " + arr[left] + " Array right: " + arr[right] +
                    " middle: " + middle);

            if (arr[middle] == searchKey) {
                return middle;
            } else if (arr[middle] < searchKey) {
                return search(arr, searchKey, middle + 1, right);
            } else {
                return search(arr, searchKey, left, middle - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 9, 11, 20, 30, 50, 80};
        int right = arr.length;
        Scanner sc = new Scanner(System.in);
        int searchKey = sc.nextInt();
        int result = search(arr, searchKey, 0, right - 1);
        if (result == -1) {
            System.out.println("Not Found!");
        } else {
            System.out.println("Found at index " + result + "!");
        }
        sc.close();
    }
}