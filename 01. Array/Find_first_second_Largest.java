public class Find_first_second_Largest {

    static int[] data = {22, 65, 1, 99, 32, 17, 74, 49, 33, 2};
    static int n, loc1, loc2, first, second;

    public static void main(String[] args) {
        n = 10;
        loc1 = -1;
        loc2 = -1;

        find(data, n);
        System.out.println("first = " + first + ", loc1 = " + loc1 + ", second = " + second + ", loc2 = " + loc2);
    }

    static void find(int[] data, int len) {
        first = data[0];
        second = data[1];
        loc1 = 0;
        loc2 = 1;
        for (int k = 2; k < len; k++) {
            if (first < data[k]) {
                second = first;
                first = data[k];
                loc2 = loc1;
                loc1 = k;
            } else if (second < data[k]) {
                second = data[k];
                loc2 = k;
            }
        }
    }
}