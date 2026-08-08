import java.util.*;

class PrimsAlgorithmQueue {
    static final int Mx = 50;
    static ArrayList<Pair>[] graph = new ArrayList[Mx];
    static int[] dis = new int[Mx];
    static int[] vis = new int[Mx];
    static int[] par = new int[Mx];

    static class Pair {
        int first, second;
        Pair(int f, int s) { first = f; second = s; }
    }

    static void prims(int src) {
        for (int i = 0; i < 10; i++) dis[i] = 10000;

        int Mst = 0;
        dis[src] = 0;
        par[src] = src;

        PriorityQueue<Pair> PQ = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));
        PQ.add(new Pair(0, src));

        while (!PQ.isEmpty()) {
            Pair p = PQ.poll();
            int u = p.second;
            if (vis[u] == 1) continue;
            vis[u] = 1;
            Mst = Mst + dis[u];
            System.out.println(u + " " + dis[u] + " " + Mst);

            for (int i = 0; i < graph[u].size(); i++) {
                int v = graph[u].get(i).first;
                if (dis[v] > graph[u].get(i).second) {
                    dis[v] = graph[u].get(i).second;
                    par[v] = u;
                    PQ.add(new Pair(dis[v], v));
                }
            }
        }

        System.out.println("Final Result is : " + Mst);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Mx; i++) graph[i] = new ArrayList<>();

        int node = sc.nextInt();
        int edge = sc.nextInt();

        for (int i = 1; i <= edge; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a].add(new Pair(b, c));
            graph[b].add(new Pair(a, c));
        }

        for (int i = 1; i <= node; i++) {
            int m = graph[i].size();
            System.out.print("Adjacency List of Node " + i + ": ");
            for (int j = 0; j < m; j++) {
                if (j > 0) System.out.print(",");
                System.out.print("(" + graph[i].get(j).first + "," + graph[i].get(j).second + ")");
            }
            System.out.println();
        }

        prims(1);
        sc.close();
    }
}