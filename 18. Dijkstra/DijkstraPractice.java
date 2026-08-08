import java.util.*;

class DijkstraPractice {
    static final int INF = 999;
    static PriorityQueue<Pair> PQ = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));
    static int[] distance = new int[INF];
    static int[] vis = new int[INF];
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

        while (!PQ.isEmpty()) {
            int val = PQ.peek().first;
            int cost = PQ.peek().second;
            PQ.poll();

            if (vis[val] == 1) continue;
            vis[val] = 1;

            for (int i = 0; i < adjListPair[val].size(); i++) {
                int nxt = adjListPair[val].get(i).first;
                int nxtCost = adjListPair[val].get(i).second;

                if (vis[nxt] == 0 && (distance[nxt] > cost + nxtCost)) {
                    distance[nxt] = cost + nxtCost;
                    PQ.add(new Pair(nxt, -distance[val]));
                }
            }
        }
        for (int i = 0; i < node; i++) {
            char nodeName = (char) (i + 'a');
            System.out.print("Node: " + nodeName + " Distance: ");
            if (distance[i] == 999) System.out.println("inf");
            else System.out.println(distance[i]);
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