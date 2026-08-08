import java.util.*;

class Activity {
    char id;
    int start, end;
}

public class ActivitySelection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tJob = sc.nextInt();
        Activity[] arr = new Activity[tJob];

        for (int i = 0; i < tJob; i++) {
            arr[i] = new Activity();
            arr[i].id = sc.next().charAt(0);
            arr[i].start = sc.nextInt();
            arr[i].end = sc.nextInt();
        }

        int work = 0;
        String workSequence = "";

        System.out.println("\nSorted 3D data ascending order according to end time:");
        for (int i = 0; i < tJob; i++) {
            System.out.println(arr[i].id + " " + arr[i].start + " " + arr[i].end);
        }

        System.out.println("\nSequenced Result: ");
        int j = 0;
        System.out.println(arr[j].id + " " + arr[j].start + " " + arr[j].end);
        workSequence += arr[j].id;
        work++;
        for (int i = 0; i < tJob; i++) {
            if (arr[i].start >= arr[j].end) {
                System.out.println(arr[i].id + " " + arr[i].start + " " + arr[i].end);
                j = i;
                workSequence += "->" + arr[i].id;
                work++;
            }
        }
        System.out.println("Total work: " + work);
        System.out.println("Work sequence: " + workSequence);
        sc.close();
    }
}