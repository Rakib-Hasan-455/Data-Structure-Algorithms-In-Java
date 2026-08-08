import java.util.Scanner;
// to detect negative cycles, we can check if dist[i][i] < 0 for any i after running the algorithm.
class FloydWarshallAlgorithm {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dist = new int[n][n];

        // Input graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();

                if (i != j && dist[i][j] == -1)
                    dist[i][j] = INF;
            }
        }

        // Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(
                                dist[i][j],
                                dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }

        // Print shortest distances
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(
                        dist[i][j] == INF ? "INF " : dist[i][j] + " "
                );
            }
            System.out.println();
        }

        sc.close();
    }
}