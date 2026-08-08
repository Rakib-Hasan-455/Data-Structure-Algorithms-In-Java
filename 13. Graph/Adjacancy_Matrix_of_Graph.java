import java.util.Scanner;

class AdjacencyMatrixOfGraph {

    static void adjacencyMatrixPrint(int[][] adjMat, int edges) {
        System.out.println("\nAdjacency Matrix:\n");
        for (int i = 0; i < edges; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < edges; j++) {
                System.out.print(adjMat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No. of nodes: ");
        int nodes = sc.nextInt();
        System.out.print("No. of edges: ");
        int edges = sc.nextInt();

        int[][] adjMat = new int[100][100];
        System.out.println("Please input " + edges + " connected nodes: ");
        for (int i = 0; i < edges; i++) {
            System.out.print((i + 1) + "th connected Edges : ");
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            adjMat[node1][node2] = 1;
            adjMat[node2][node1] = 1;
        }

        adjacencyMatrixPrint(adjMat, edges);
        sc.close();
    }
}