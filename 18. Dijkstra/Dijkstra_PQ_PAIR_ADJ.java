import java.util.*;

class Dijkstra_PQ_PAIR_ADJ {
    static final int INF = 999;
    static PriorityQueue<Pair> PQ = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));
    static int[] distance = new int[INF];
    static ArrayList<Pair>[] adjListPair = new ArrayList[INF];
    static int node, edge;

    static class Pair {
        int first, second;
        Pair(int f, int s) { first = f; second = s; }
    }

    static void adjListPairInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" ");
        node = sc.nextInt();
        edge = sc.nextInt();
        for (int i = 0; i < INF; i++) adjListPair[i] = new ArrayList<>();
        for (int i = 0; i < edge; i++) {
            System.out.print(" ");
            char node1 = sc.next().charAt(0);
            char node2 = sc.next().charAt(0);
            int node1Index = Character.toLowerCase(node1) - 'a';
            int node2Index = Character.toLowerCase(node2) - 'a';
            int dist = sc.nextInt();
            adjListPair[node1Index].add(new Pair(node2Index, dist));
        }
        adjListPairPrint(node);
    }

    static void adjListPairPrint(int node) {
        System.out.println(" Adjacancy List pair: ");
        for (int i = 0; i < node; i++) {
            char listName = (char) ('a' + i);
            System.out.print(" " + listName + " : ");
            for (int j = 0; j < adjListPair[i].size(); j++) {
                char pairNode = (char) (adjListPair[i].get(j).first + 'a');
                int pairDist = adjListPair[i].get(j).second;
                System.out.print("(" + pairNode + ", " + pairDist + ")");
                if (j + 1 != adjListPair[i].size()) System.out.print(" , ");
            }
            System.out.println();
        }
    }

    static void dijkstra(int source) {
        for (int i = 0; i < node; i++) distance[i] = 999;
        distance[source] = 0;
        PQ.add(new Pair(source, distance[source]));

        String[] color = new String[INF];
        for (int i = 0; i < node; i++) color[i] = "white";
        color[source] = "gray";

        int nodeCount = 0;
        char[] bfsSequence = new char[INF];
        bfsSequence[nodeCount++] = (char) (source + 'a');

        char nodeName = (char) (source + 'a');
        int step = 1;
        System.out.println("\n Step " + step + " :\n Visited = " + " (" + nodeName + ", " + distance[source] + ") " + ", Color = " + color[source]);
        System.out.println(" Queue = " + " (" + nodeName + ", " + distance[source] + ") ");
        System.out.print(" after Updating Distance: ");
        for (int i = 0; i < node; i++) {
            nodeName = (char) (i + 'a');
            System.out.print("(" + nodeName + ", " + distance[i] + ")");
            if (i + 1 != node) System.out.print(", ");
        }
        System.out.println();

        while (!PQ.isEmpty()) {
            boolean updateConfirm = false;
            int pqCurrentFrontNode = PQ.peek().first;
            int pqCurrentFrontDistance = PQ.peek().second;
            PQ.poll();

            color[pqCurrentFrontNode] = "black";
            nodeName = (char) (pqCurrentFrontNode + 'a');
            step++;
            System.out.println("\n Step " + step + " :\n Popped  = " + "(" + nodeName + ", " + (-pqCurrentFrontDistance) + ") " + ", Color = " + color[pqCurrentFrontNode]);

            for (int i = 0; i < adjListPair[pqCurrentFrontNode].size(); i++) {
                int qFrontElementsNode = adjListPair[pqCurrentFrontNode].get(i).first;
                int qFrontToElementsDistance = adjListPair[pqCurrentFrontNode].get(i).second;

                if (distance[qFrontElementsNode] > distance[pqCurrentFrontNode] + qFrontToElementsDistance) {
                    bfsSequence[nodeCount++] = (char) (qFrontElementsNode + 'a');
                    distance[qFrontElementsNode] = distance[pqCurrentFrontNode] + qFrontToElementsDistance;
                    color[qFrontElementsNode] = "gray";

                    PQ.add(new Pair(qFrontElementsNode, -distance[qFrontElementsNode]));

                    nodeName = (char) (qFrontElementsNode + 'a');
                    System.out.println(" Visited = " + "(" + nodeName + ", " + distance[qFrontElementsNode] + ") " + ", Color = " + color[qFrontElementsNode]);
                    updateConfirm = true;
                }
            }
            if (updateConfirm) {
                System.out.print(" after Updating Distance: ");
                for (int i = 0; i < node; i++) {
                    nodeName = (char) (i + 'a');
                    System.out.print("(" + nodeName + ", " + distance[i] + ")");
                    if (i + 1 != node) System.out.print(", ");
                }
                System.out.println();
            } else {
                System.out.println(" No node Distance updated in this step.");
            }
        }
        System.out.print("\n BFS node update sequence  ");
        for (int i = 0; i < nodeCount; i++) {
            System.out.print(" -> " + bfsSequence[i]);
        }
        System.out.println();
        for (int i = 0; i < node; i++) {
            nodeName = (char) (i + 'a');
            System.out.println(" Minimum distance of: " + nodeName + " = " + distance[i]);
        }
    }

    public static void main(String[] args) {
        adjListPairInput();
        Scanner sc = new Scanner(System.in);
        System.out.print(" Source: ");
        char source = sc.next().charAt(0);
        int sourceIndex = source - 'a';
        dijkstra(sourceIndex);
    }
}