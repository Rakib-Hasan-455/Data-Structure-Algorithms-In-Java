import java.util.*;

class GraphRepresentationWithAdjMatrix {
    static final int INF = 999;
    static int[][] adjMatrix = new int[INF][INF];
    static ArrayList<Integer>[] adjList = new ArrayList[INF];

    static void adjMatrixPrint(int node) {
        for (int i = 0; i < node; i++) {
            for (int j = 0; j < node; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void adjMatrixInput() {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();
        for (int i = 0; i < edge; i++) {
            char node1 = sc.next().charAt(0);
            char node2 = sc.next().charAt(0);
            int node1Index = Character.toLowerCase(node1) - 'a';
            int node2Index = Character.toLowerCase(node2) - 'a';
            adjMatrix[node1Index][node2Index] = 1;
            adjMatrix[node2Index][node1Index] = 1;
        }
        adjMatrixPrint(node);
    }

    static void connectedAdjMatNode() {
        Scanner sc = new Scanner(System.in);
        char node1 = sc.next().charAt(0);
        char node2 = sc.next().charAt(0);
        int node1Index = Character.toLowerCase(node1) - 'a';
        int node2Index = Character.toLowerCase(node2) - 'a';
        System.out.println(adjMatrix[node1Index][node2Index] + " " + adjMatrix[node2Index][node1Index]);
        if (adjMatrix[node1Index][node2Index] == adjMatrix[node2Index][node1Index]
                && adjMatrix[node1Index][node2Index] == 1
                && adjMatrix[node2Index][node1Index] == 1) {
            System.out.println("They are connected!");
        } else {
            System.out.println("They are not connected!");
        }
    }

    static void adjListPrint(int node) {
        for (int i = 0; i < node; i++) {
            char listName = (char) ('a' + i);
            System.out.print(listName + " : ");
            for (int j = 0; j < adjList[i].size(); j++) {
                char listElements = (char) (adjList[i].get(j) + 'a');
                System.out.print(listElements + " ");
            }
            System.out.println();
        }
    }

    static void adjListInput() {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edge = sc.nextInt();

        for (int i = 0; i < INF; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < edge; i++) {
            char node1 = sc.next().charAt(0);
            char node2 = sc.next().charAt(0);
            int node1Index = Character.toLowerCase(node1) - 'a';
            int node2Index = Character.toLowerCase(node2) - 'a';
            adjList[node1Index].add(node2Index);
            adjList[node2Index].add(node1Index);
        }
        adjListPrint(node);
    }

    static void connectedListNode() {
        Scanner sc = new Scanner(System.in);
        char node1 = sc.next().charAt(0);
        char node2 = sc.next().charAt(0);
        int node1Index = Character.toLowerCase(node1) - 'a';
        int node2Index = Character.toLowerCase(node2) - 'a';
        boolean flag = false;
        for (int i = 0; i < adjList[node1Index].size(); i++) {
            int listElements = adjList[node1Index].get(i);
            if (node2Index == listElements) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("They are connected!");
        } else {
            System.out.println("They are not connected!");
        }
    }

    public static void main(String[] args) {
        adjMatrixInput();
        while (true) connectedAdjMatNode();
    }
}