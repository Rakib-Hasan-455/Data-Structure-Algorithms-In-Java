import java.io.*;
import java.util.Scanner;

public class All_Sorting_Algo_Analysis {
    static double bubbleSortInp1_AcTime = 10000, bubbleSortInp2_AcTime = 10000, bubbleSortInp3_AcTime = 10000;
    static double bubbleSortInp1_DcTime = 10000, bubbleSortInp2_DcTime = 10000, bubbleSortInp3_DcTime = 10000;
    static double insertSortInp1_AcTime = 10000, insertSortInp2_AcTime = 10000, insertSortInp3_AcTime = 10000;
    static double insertSortInp1_DcTime = 10000, insertSortInp2_DcTime = 10000, insertSortInp3_DcTime = 10000;
    static double mergeSortInp1_AcTime = 10000, mergeSortInp2_AcTime = 10000, mergeSortInp3_AcTime = 10000;
    static double mergeSortInp1_DcTime = 10000, mergeSortInp2_DcTime = 10000, mergeSortInp3_DcTime = 10000;
    static double quickSortInp1_AcTime = 10000, quickSortInp2_AcTime = 10000, quickSortInp3_AcTime = 10000;
    static double quickSortInp1_DcTime = 10000, quickSortInp2_DcTime = 10000, quickSortInp3_DcTime = 10000;

    static double bubbleSortAcceding() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        long sortStart = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        long sortEnd = System.nanoTime();
        double sortTime = (double) (sortEnd - sortStart) / 1_000_000_000.0;
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) pw.println(arr[i]);
        pw.flush();
        return sortTime;
    }

    static double bubbleSortDecending() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        long sortStart = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        long sortEnd = System.nanoTime();
        double sortTime = (double) (sortEnd - sortStart) / 1_000_000_000.0;
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) pw.println(arr[i]);
        pw.flush();
        return sortTime;
    }

    static double insertSortAcceding() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        long sortStart = System.nanoTime();
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        long sortEnd = System.nanoTime();
        double sortTime = (double) (sortEnd - sortStart) / 1_000_000_000.0;
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) pw.println(arr[i]);
        pw.flush();
        System.out.println("Accending Order insert sort time: " + sortTime + " second");
        return sortTime;
    }

    static double insertSortDecending() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        long sortStart = System.nanoTime();
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        long sortEnd = System.nanoTime();
        double sortTime = (double) (sortEnd - sortStart) / 1_000_000_000.0;
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) pw.println(arr[i]);
        pw.flush();
        System.out.println("Decending Order insert sort time: " + sortTime + " second");
        return sortTime;
    }

    static void mergeAccend(int[] arr, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int k = 0, i = lo, j = mid + 1;
        while (i <= mid && j <= hi) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
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

    static double mergeSortAcceding() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        long sortStart = System.nanoTime();
        mergeSortAccend(arr, 0, n - 1);
        long sortEnd = System.nanoTime();
        double sortTime = (double) (sortEnd - sortStart) / 1_000_000_000.0;
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) pw.println(arr[i]);
        pw.flush();
        return sortTime;
    }

    static void mergeDecend(int[] arr, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int k = 0, i = lo, j = mid + 1;
        while (i <= mid && j <= hi) {
            if (arr[i] > arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= hi) temp[k++] = arr[j++];
        for (i = lo, k = 0; i <= hi; i++, k++) arr[i] = temp[k];
    }

    static void mergeSortDecend(int[] arr, int lo, int hi) {
        if (lo == hi) return;
        int mid = (lo + hi) / 2;
        mergeSortDecend(arr, lo, mid);
        mergeSortDecend(arr, mid + 1, hi);
        mergeDecend(arr, lo, mid, hi);
    }

    static double mergeSortDecending() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        long sortStart = System.nanoTime();
        mergeSortDecend(arr, 0, n - 1);
        long sortEnd = System.nanoTime();
        double sortTime = (double) (sortEnd - sortStart) / 1_000_000_000.0;
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) pw.println(arr[i]);
        pw.flush();
        return sortTime;
    }

    static void quickSortAccend(int[] array, int low, int high) {
        int i = low;
        int j = high;
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

    static double quickSortAcceding() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = sc.nextInt();

        long sortStart = System.nanoTime();
        quickSortAccend(array, 0, n - 1);
        long sortEnd = System.nanoTime();
        double sortTime = (double) (sortEnd - sortStart) / 1_000_000_000.0;
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) pw.println(array[i]);
        pw.flush();
        return sortTime;
    }

    static void quickSortDecend(int[] array, int low, int high) {
        int i = low;
        int j = high;
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

    static double quickSortDecending() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = sc.nextInt();

        long sortStart = System.nanoTime();
        quickSortDecend(array, 0, n - 1);
        long sortEnd = System.nanoTime();
        double sortTime = (double) (sortEnd - sortStart) / 1_000_000_000.0;
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) pw.println(array[i]);
        pw.flush();
        return sortTime;
    }

    static void bubbleSortAccending1() throws Exception {
        System.setIn(new FileInputStream("input1.txt"));
        System.setOut(new PrintStream("bubbleSortAccending_Input1.txt"));
        bubbleSortInp1_AcTime = bubbleSortAcceding();
    }

    static void bubbleSortAccending2() throws Exception {
        System.setIn(new FileInputStream("input2.txt"));
        System.setOut(new PrintStream("bubbleSortAccending_Input2.txt"));
        bubbleSortInp2_AcTime = bubbleSortAcceding();
    }

    static void bubbleSortAccending3() throws Exception {
        System.setIn(new FileInputStream("input3.txt"));
        System.setOut(new PrintStream("bubbleSortAccending_Input3.txt"));
        bubbleSortInp3_AcTime = bubbleSortAcceding();
    }

    static void bubbleSortDecending1() throws Exception {
        System.setIn(new FileInputStream("input1.txt"));
        System.setOut(new PrintStream("bubbleSortDecending_Input1.txt"));
        bubbleSortInp1_DcTime = bubbleSortDecending();
    }

    static void bubbleSortDecending2() throws Exception {
        System.setIn(new FileInputStream("input2.txt"));
        System.setOut(new PrintStream("bubbleSortDecending_Input2.txt"));
        bubbleSortInp2_DcTime = bubbleSortDecending();
    }

    static void bubbleSortDecending3() throws Exception {
        System.setIn(new FileInputStream("input3.txt"));
        System.setOut(new PrintStream("bubbleSortDecending_Input3.txt"));
        bubbleSortInp3_DcTime = bubbleSortDecending();
    }

    static void insertSortAccending1() throws Exception {
        System.setIn(new FileInputStream("input1.txt"));
        System.setOut(new PrintStream("insertSortAccending_Input1.txt"));
        insertSortInp1_AcTime = insertSortAcceding();
    }

    static void insertSortAccending2() throws Exception {
        System.setIn(new FileInputStream("input2.txt"));
        System.setOut(new PrintStream("insertSortAccending_Input2.txt"));
        insertSortInp2_AcTime = insertSortAcceding();
    }

    static void insertSortAccending3() throws Exception {
        System.setIn(new FileInputStream("input3.txt"));
        System.setOut(new PrintStream("insertSortAccending_Input3.txt"));
        insertSortInp3_AcTime = insertSortAcceding();
    }

    static void insertSortDecending1() throws Exception {
        System.setIn(new FileInputStream("input1.txt"));
        System.setOut(new PrintStream("insertSortDecending_Input1.txt"));
        insertSortInp1_DcTime = insertSortDecending();
    }

    static void insertSortDecending2() throws Exception {
        System.setIn(new FileInputStream("input2.txt"));
        System.setOut(new PrintStream("insertSortDecending_Input2.txt"));
        insertSortInp2_DcTime = insertSortDecending();
    }

    static void insertSortDecending3() throws Exception {
        System.setIn(new FileInputStream("input3.txt"));
        System.setOut(new PrintStream("insertSortDecending_Input3.txt"));
        insertSortInp3_DcTime = insertSortDecending();
    }

    static void mergeSortAccending1() throws Exception {
        System.setIn(new FileInputStream("input1.txt"));
        System.setOut(new PrintStream("mergeSortAccending_Input1.txt"));
        mergeSortInp1_AcTime = mergeSortAcceding();
    }

    static void mergeSortAccending2() throws Exception {
        System.setIn(new FileInputStream("input2.txt"));
        System.setOut(new PrintStream("mergeSortAccending_Input2.txt"));
        mergeSortInp2_AcTime = mergeSortAcceding();
    }

    static void mergeSortAccending3() throws Exception {
        System.setIn(new FileInputStream("input3.txt"));
        System.setOut(new PrintStream("mergeSortAccending_Input3.txt"));
        mergeSortInp3_AcTime = mergeSortAcceding();
    }

    static void mergeSortDecending1() throws Exception {
        System.setIn(new FileInputStream("input1.txt"));
        System.setOut(new PrintStream("mergeSortDecending_Input1.txt"));
        mergeSortInp1_DcTime = mergeSortDecending();
    }

    static void mergeSortDecending2() throws Exception {
        System.setIn(new FileInputStream("input2.txt"));
        System.setOut(new PrintStream("mergeSortDecending_Input2.txt"));
        mergeSortInp2_DcTime = mergeSortDecending();
    }

    static void mergeSortDecending3() throws Exception {
        System.setIn(new FileInputStream("input3.txt"));
        System.setOut(new PrintStream("mergeSortDecending_Input3.txt"));
        mergeSortInp3_DcTime = mergeSortDecending();
    }

    static void quickSortAccending1() throws Exception {
        System.setIn(new FileInputStream("input1.txt"));
        System.setOut(new PrintStream("quickSortAccending_Input1.txt"));
        quickSortInp1_AcTime = quickSortAcceding();
    }

    static void quickSortAccending2() throws Exception {
        System.setIn(new FileInputStream("input2.txt"));
        System.setOut(new PrintStream("quickSortAccending_Input2.txt"));
        quickSortInp2_AcTime = quickSortAcceding();
    }

    static void quickSortAccending3() throws Exception {
        System.setIn(new FileInputStream("input3.txt"));
        System.setOut(new PrintStream("quickSortAccending_Input3.txt"));
        quickSortInp3_AcTime = quickSortAcceding();
    }

    static void quickSortDecending1() throws Exception {
        System.setIn(new FileInputStream("input1.txt"));
        System.setOut(new PrintStream("quickSortDecending_Input1.txt"));
        quickSortInp1_DcTime = quickSortDecending();
    }

    static void quickSortDecending2() throws Exception {
        System.setIn(new FileInputStream("input2.txt"));
        System.setOut(new PrintStream("quickSortDecending_Input2.txt"));
        quickSortInp2_DcTime = quickSortDecending();
    }

    static void quickSortDecending3() throws Exception {
        System.setIn(new FileInputStream("input3.txt"));
        System.setOut(new PrintStream("quickSortDecending_Input3.txt"));
        quickSortInp3_DcTime = quickSortDecending();
    }

    static void generateReport() throws Exception {
        System.setOut(new PrintStream("ReportFileOfSortingAlgo.txt"));
        System.out.println("Input 1:");
        System.out.println("Bubble Sort: = Ascending : " + bubbleSortInp1_AcTime + "s, Descending : " + bubbleSortInp1_DcTime + "s");
        System.out.println("Insert Sort: = Ascending : " + insertSortInp1_AcTime + "s, Descending : " + insertSortInp1_DcTime + "s");
        System.out.println("Merge Sort: = Ascending : " + mergeSortInp1_AcTime + "s, Descending : " + mergeSortInp1_DcTime + "s");
        System.out.println("Quick Sort: = Ascending : " + quickSortInp1_AcTime + "s, Descending : " + quickSortInp1_DcTime + "s");
        System.out.print("Best Sorting: = Ascending : ");
        if (bubbleSortInp1_AcTime < insertSortInp1_AcTime && bubbleSortInp1_AcTime < mergeSortInp1_AcTime && bubbleSortInp1_AcTime < quickSortInp1_AcTime) {
            System.out.print("Bubble Sort");
        } else if (insertSortInp1_AcTime < mergeSortInp1_AcTime && insertSortInp1_AcTime < quickSortInp1_AcTime) {
            System.out.print("Insertion Sort");
        } else if (mergeSortInp1_AcTime < quickSortInp1_AcTime) {
            System.out.print("Merge Sort");
        } else {
            System.out.print("Quick Sort");
        }
        System.out.println(", Descending: ");
        if (bubbleSortInp1_DcTime < insertSortInp1_DcTime && bubbleSortInp1_DcTime < mergeSortInp1_DcTime && bubbleSortInp1_DcTime < quickSortInp1_DcTime) {
            System.out.print("Bubble Sort");
        } else if (insertSortInp1_DcTime < mergeSortInp1_DcTime && insertSortInp1_DcTime < quickSortInp1_DcTime) {
            System.out.print("Insertion Sort");
        } else if (mergeSortInp1_DcTime < quickSortInp1_DcTime) {
            System.out.print("Merge Sort");
        } else {
            System.out.print("Quick Sort");
        }
        System.out.println("\n\n\n");

        System.out.println("Input 2:");
        System.out.println("Bubble Sort: = Ascending : " + bubbleSortInp2_AcTime + "s, Descending : " + bubbleSortInp2_DcTime + "s");
        System.out.println("Insert Sort: = Ascending : " + insertSortInp2_AcTime + "s, Descending : " + insertSortInp2_DcTime + "s");
        System.out.println("Merge Sort: = Ascending : " + mergeSortInp2_AcTime + "s, Descending : " + mergeSortInp2_DcTime + "s");
        System.out.println("Quick Sort: = Ascending : " + quickSortInp2_AcTime + "s, Descending : " + quickSortInp2_DcTime + "s");
        System.out.print("Best Sorting: = Ascending : ");
        if (bubbleSortInp2_AcTime < insertSortInp2_AcTime && bubbleSortInp2_AcTime < mergeSortInp2_AcTime && bubbleSortInp2_AcTime < quickSortInp2_AcTime) {
            System.out.print("Bubble Sort");
        } else if (insertSortInp2_AcTime < mergeSortInp2_AcTime && insertSortInp2_AcTime < quickSortInp2_AcTime) {
            System.out.print("Insertion Sort");
        } else if (mergeSortInp2_AcTime < quickSortInp2_AcTime) {
            System.out.print("Merge Sort");
        } else {
            System.out.print("Quick Sort");
        }
        System.out.println(", Descending: ");
        if (bubbleSortInp2_DcTime < insertSortInp2_DcTime && bubbleSortInp2_DcTime < mergeSortInp2_DcTime && bubbleSortInp2_DcTime < quickSortInp2_DcTime) {
            System.out.print("Bubble Sort");
        } else if (insertSortInp2_DcTime < mergeSortInp2_DcTime && insertSortInp2_DcTime < quickSortInp2_DcTime) {
            System.out.print("Insertion Sort");
        } else if (mergeSortInp2_DcTime < quickSortInp2_DcTime) {
            System.out.print("Merge Sort");
        } else {
            System.out.print("Quick Sort");
        }
        System.out.println("\n\n\n");

        System.out.println("Input 3:");
        System.out.println("Bubble Sort: = Ascending : " + bubbleSortInp3_AcTime + "s, Descending : " + bubbleSortInp3_DcTime + "s");
        System.out.println("Insert Sort: = Ascending : " + insertSortInp3_AcTime + "s, Descending : " + insertSortInp3_DcTime + "s");
        System.out.println("Merge Sort: = Ascending : " + mergeSortInp3_AcTime + "s, Descending : " + mergeSortInp3_DcTime + "s");
        System.out.println("Quick Sort: = Ascending : " + quickSortInp3_AcTime + "s, Descending : " + quickSortInp3_DcTime + "s");
        System.out.print("Best Sorting: = Ascending : ");
        if (bubbleSortInp3_AcTime < insertSortInp3_AcTime && bubbleSortInp3_AcTime < mergeSortInp3_AcTime && bubbleSortInp3_AcTime < quickSortInp3_AcTime) {
            System.out.print("Bubble Sort");
        } else if (insertSortInp3_AcTime < mergeSortInp3_AcTime && insertSortInp3_AcTime < quickSortInp3_AcTime) {
            System.out.print("Insertion Sort");
        } else if (mergeSortInp3_AcTime < quickSortInp3_AcTime) {
            System.out.print("Merge Sort");
        } else {
            System.out.print("Quick Sort");
        }
        System.out.println(", Descending: ");
        if (bubbleSortInp3_DcTime < insertSortInp3_DcTime && bubbleSortInp3_DcTime < mergeSortInp3_DcTime && bubbleSortInp3_DcTime < quickSortInp3_DcTime) {
            System.out.print("Bubble Sort");
        } else if (insertSortInp3_DcTime < mergeSortInp3_DcTime && insertSortInp3_DcTime < quickSortInp3_DcTime) {
            System.out.print("Insertion Sort");
        } else if (mergeSortInp3_DcTime < quickSortInp3_DcTime) {
            System.out.print("Merge Sort");
        } else {
            System.out.print("Quick Sort");
        }
        System.out.println("\n\n\n");
    }

    public static void main(String[] args) throws Exception {
        bubbleSortAccending1();
        bubbleSortDecending1();

        insertSortAccending1();
        insertSortAccending2();
        insertSortAccending3();
        insertSortDecending1();
        insertSortDecending2();
        insertSortDecending3();

        mergeSortAccending1();
        mergeSortAccending2();
        mergeSortAccending3();
        mergeSortDecending1();
        mergeSortDecending2();
        mergeSortDecending3();

        quickSortAccending1();
        quickSortAccending2();
        quickSortAccending3();
        quickSortDecending1();
        quickSortDecending2();
        quickSortDecending3();

        generateReport();
    }
}