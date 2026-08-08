class PrimsAlgorithm {
    static final int n = 5;

    static void printMST(int[] a, int[] b, int[] weight) {
        int Minweight = 0;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Edge: " + a[i] + "-" + b[i] + " cost: " + weight[i]);
            Minweight += weight[i];
        }
        System.out.println("Minimum Weight is " + Minweight);
    }

    static void prim(int[][] cost) {
        int u = 0, v = 0, k = 0, counti = 0;
        int[] visited = new int[n];
        int[] a = new int[n];
        int[] b = new int[n];
        int[] weight = new int[n];
        int minimum;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (cost[i][j] == 0)
                    cost[i][j] = Integer.MAX_VALUE;

        visited[0] = 1;

        while (counti < n - 1) {
            minimum = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i] != 0 && cost[i][j] < minimum) {
                        minimum = cost[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            if (visited[u] == 0 || visited[v] == 0) {
                a[k] = u;
                b[k] = v;
                weight[k] = cost[u][v];
                counti++;
                k++;
                visited[v] = 1;
            }

            cost[u][v] = cost[v][u] = Integer.MAX_VALUE;
        }

        printMST(a, b, weight);
    }

    public static void main(String[] args) {
        int[][] cost = {
            { 0, 2, 4, 0, 0 },
            { 2, 0, 1, 8, 6 },
            { 4, 1, 0, 7, 0 },
            { 0, 8, 7, 0, 3 },
            { 0, 6, 0, 3, 0 }
        };

        prim(cost);
    }
}