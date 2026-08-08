import java.util.*;

class BFS_ {
    static final int INF = 999;
    static int[][] adjMatrix = new int[INF][INF];
    static ArrayList<Integer>[] adjList = new ArrayList[INF];
    static int node, edge;

    static void adjListPrint(int node) {
        System.out.println("Adjacancy List: ");
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
        node = sc.nextInt();
        edge = sc.nextInt();

        for (int i = 0; i < INF; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < edge; i++) {
            char node1 = sc.next().charAt(0);
            char node2 = sc.next().charAt(0);
            int node1Index = Character.toLowerCase(node1) - 'a';
            int node2Index = Character.toLowerCase(node2) - 'a';
            adjList[node1Index].add(node2Index);
            adjList[node2Index].add(node1Index);
        }
    }

    static void BFS(int source, int destination) {
        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited = new boolean[INF];
        visited[source] = true;
        int[] level = new int[INF];
        level[source] = 0;
        Q.add(source);
        int nodeCount = 0;
        char[] bfsSequence = new char[INF];
        bfsSequence[nodeCount] = (char) (source + 'a');
        nodeCount++;

        while (!Q.isEmpty()) {
            int qFrontCurrent = Q.poll();

            for (int i = 0; i < adjList[qFrontCurrent].size(); i++) {
                int qFrontElements = adjList[qFrontCurrent].get(i);
                if (!visited[qFrontElements]) {
                    bfsSequence[nodeCount++] = (char) (qFrontElements + 'a');
                    visited[qFrontElements] = true;
                    level[qFrontElements] = level[qFrontCurrent] + 1;
                    Q.add(qFrontElements);
                    if (qFrontElements == destination) {
                        Q.clear();
                        break;
                    }
                }
            }
        }

        System.out.print("BFS node visiting sequence  ");
        int levelIndex = 0;
        for (int i = 0; i < nodeCount; i++) {
            System.out.print(" -> " + bfsSequence[i]);
            levelIndex = bfsSequence[i] - 'a';
        }
        System.out.println("\nMinimum distance: " + level[levelIndex]);
    }

    public static void main(String[] args) {
        adjListInput();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source: ");
        char source = sc.next().charAt(0);
        System.out.print("Enter destination: ");
        char destination = sc.next().charAt(0);
        int sourceIndex = Character.toLowerCase(source) - 'a';
        int destinationIndex = Character.toLowerCase(destination) - 'a';
        BFS(sourceIndex, destinationIndex);
    }
}