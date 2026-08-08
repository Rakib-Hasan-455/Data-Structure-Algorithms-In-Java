import java.util.*;

class BFS_GRAY_BLACK {
    static final int INF = 999;
    static int[][] adjMatrix = new int[INF][INF];
    static ArrayList<Integer>[] adjList = new ArrayList[INF];
    static int node, edge;

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
        Queue<Integer> Q2 = new LinkedList<>();
        Q.add(source);

        String[] color = new String[INF];
        for (int i = 0; i < node; i++) color[i] = "white";
        color[source] = "gray";

        int[] level = new int[INF];
        level[source] = 0;

        int nodeCount = 0;
        char[] bfsSequence = new char[INF];
        bfsSequence[nodeCount++] = (char) (source + 'a');

        char nodeName = (char) (source + 'a');
        int step = 1;
        System.out.println("\n Step " + step + " :\n Visited = " + nodeName + ", Color = " + color[source]);
        System.out.println(" Queue = " + nodeName + "\n");

        while (!Q.isEmpty()) {
            int qFrontCurrent = Q.poll();
            color[qFrontCurrent] = "black";
            nodeName = (char) (qFrontCurrent + 'a');
            step++;
            System.out.println(" Step " + step + " :\n Popped  = " + nodeName + ", Color = " + color[qFrontCurrent]);

            for (int i = 0; i < adjList[qFrontCurrent].size(); i++) {
                int qFrontElements = adjList[qFrontCurrent].get(i);
                if (color[qFrontElements].equals("white")) {
                    bfsSequence[nodeCount++] = (char) (qFrontElements + 'a');
                    color[qFrontElements] = "gray";
                    level[qFrontElements] = level[qFrontCurrent] + 1;
                    Q.add(qFrontElements);
                    nodeName = (char) (qFrontElements + 'a');
                    System.out.println(" Visited = " + nodeName + ", Color = " + color[qFrontElements]);

                    if (qFrontElements == destination) {
                        Q2 = new LinkedList<>(Q);
                        System.out.print(" Current Queue: ");
                        while (!Q2.isEmpty()) {
                            nodeName = (char) (Q2.poll() + 'a');
                            System.out.print(nodeName + " ");
                        }
                        System.out.println("\n");
                        while (!Q.isEmpty()) {
                            int popped = Q.poll();
                            nodeName = (char) (popped + 'a');
                            color[popped] = "black";
                            step++;
                            System.out.println("\n Step " + step + " :\n Popped  = " + nodeName + ", Color = " + color[popped]);
                            Q2 = new LinkedList<>(Q);
                            System.out.print(" Current Queue: ");
                            while (!Q2.isEmpty()) {
                                nodeName = (char) (Q2.poll() + 'a');
                                System.out.print(nodeName + " ");
                            }
                            System.out.println("\n");
                        }
                        break;
                    }
                }
            }

            Q2 = new LinkedList<>(Q);
            if (!Q2.isEmpty()) {
                System.out.print(" Current Queue: ");
                while (!Q2.isEmpty()) {
                    nodeName = (char) (Q2.poll() + 'a');
                    System.out.print(nodeName + " ");
                }
                System.out.println("\n");
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