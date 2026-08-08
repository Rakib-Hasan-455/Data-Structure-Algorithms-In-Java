import java.util.Scanner;

class TowerOfHanoi {

    static void towerOfHanoi(int n, char from, char to, char rem) {
        if (n == 1) {
            System.out.println("Moved disk " + n + " from " + from + " to " + to);
            return;
        }
        towerOfHanoi(n - 1, from, rem, to);
        System.out.println("Moved disk " + n + " from " + from + " to " + to);
        towerOfHanoi(n - 1, rem, to, from);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No of disks: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.print("Start from: ");
        char fromRod = sc.nextLine().charAt(0);
        System.out.print("Shift to: ");
        char toRod = sc.nextLine().charAt(0);
        System.out.print("Remind rod: ");
        char remRod = sc.nextLine().charAt(0);
        towerOfHanoi(n, fromRod, toRod, remRod);
        sc.close();
    }
}