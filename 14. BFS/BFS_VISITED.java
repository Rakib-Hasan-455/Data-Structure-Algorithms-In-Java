import java.util.*;

class BFS_VISITED {
    static final int INF = 999;
    static ArrayList<Integer>[] adjList = new ArrayList[INF];
    static int node, edge;

    static void adjListInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of node: ");
        node = sc.nextInt();
        System.out.println("Number of edge: ");
        edge = sc.nextInt();
        System.out.println("Enter connected edges: ");
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
        Q.add(source);

        boolean[] visited = new boolean[INF];
        visited[source] = true;

        int[] level = new int[INF];
        level[source] = 0;

        int nodeCount = 0;
        char[] bfsSequence = new char[INF];
        bfsSequence[nodeCount++] = (char) (source + 'a');

        while (!Q.isEmpty()) {
            int qFrontCurrent = Q.poll();

            for (int i = 0; i < adjList[qFrontCurrent].size(); i++) {
                int qFrontElements = adjList[qFrontCurrent].get(i);
                if (!visited[qFrontElements]) {
                    Q.add(qFrontElements);
                    visited[qFrontElements] = true;
                    level[qFrontElements] = level[qFrontCurrent] + 1;
                    bfsSequence[nodeCount++] = (char) (qFrontElements + 'a');

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
        int minDistance = level[levelIndex];
        System.out.print("\nShortest Path: ");
        for (int i = 0; i <= minDistance; i++) {
            for (int k = 0; k < edge; k++) {
                if (level[k] == i) {
                    char nodeName = (char) (k + 'a');
                    System.out.print(nodeName + " ");
                    break;
                }
            }
        }
        System.out.println("\nMinimum distance: " + minDistance);
    }

    public static void main(String[] args) {
        adjListInput();
        Scanner sc = new Scanner(System.in);
        char source, destination;
        System.out.print("Enter source: ");
        source = sc.next().charAt(0);
        System.out.print("Enter destination: ");
        destination = sc.next().charAt(0);
        int sourceIndex = Character.toLowerCase(source) - 'a';
        int destinationIndex = Character.toLowerCase(destination) - 'a';
        BFS(sourceIndex, destinationIndex);
    }
}