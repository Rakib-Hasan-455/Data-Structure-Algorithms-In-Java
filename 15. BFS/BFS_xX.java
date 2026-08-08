import java.util.*;

class BFS_xX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<Integer>[] edges = new ArrayList[1000];
        for (int i = 0; i < 1000; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            x--;
            y--;
            edges[x].add(y);
            edges[y].add(x);
        }

        Queue<Integer> Q = new LinkedList<>();
        int[] level = new int[N];
        for (int i = 0; i < N; i++) level[i] = -1;

        int s = sc.nextInt();
        int d = sc.nextInt();
        s--;
        d--;

        Q.add(s);
        level[s] = 0;

        System.out.print("BFS Traversal result => ");
        System.out.print((s + 1) + " ");

        while (!Q.isEmpty()) {
            int u = Q.poll();
            int edgeSize = edges[u].size();
            for (int i = 0; i < edgeSize; i++) {
                int v = edges[u].get(i);
                if (level[v] == -1) {
                    System.out.print((v + 1) + " ");
                    Q.add(v);
                    level[v] = level[u] + 1;
                }
            }
        }

        System.out.println("\nDistance:" + level[d] + " ");
        sc.close();
    }
}