import java.util.*;

class Node1 {
    int val, cost;
    Node1(int v, int c) { val = v; cost = c; }
}

class DijkstraPractice1 {
    static final int MX = 105;
    static final int INF = 1000000000;
    static ArrayList<Node1>[] G = new ArrayList[MX];
    static boolean[] vis = new boolean[MX];
    static int[] dist = new int[MX];

    static void reset() {
        for (int i = 0; i < MX; i++) {
            G[i] = new ArrayList<>();
            vis[i] = false;
            dist[i] = INF;
        }
    }

    static void dijkstra(int source) {
        PriorityQueue<Node1> PQ = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        PQ.add(new Node1(source, 0));

        while (!PQ.isEmpty()) {
            Node1 current = PQ.poll();
            int val = current.val;
            int cost = current.cost;

            if (vis[val]) continue;

            dist[val] = cost;
            vis[val] = true;

            for (int i = 0; i < G[val].size(); i++) {
                int nxt = G[val].get(i).val;
                int nxtCost = G[val].get(i).cost;

                if (!vis[nxt]) {
                    PQ.add(new Node1(nxt, cost + nxtCost));
                }
            }
        }
    }

    public static void main(String[] args) {
        reset();
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();

        for (int i = 1; i <= edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            G[u].add(new Node1(v, w));
        }

        System.out.print("enter source: ");
        int source = sc.nextInt();

        dijkstra(source);
        for (int i = 1; i <= nodes; i++) {
            System.out.print("Node: " + i + " Distance: ");
            if (dist[i] == INF) System.out.println("inf");
            else System.out.println(dist[i]);
        }
        sc.close();
    }
}