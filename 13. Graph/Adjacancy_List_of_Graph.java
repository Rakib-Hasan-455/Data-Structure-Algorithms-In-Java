import java.util.ArrayList;
import java.util.Scanner;

class AdjacencyListOfGraph {

    static void adjacencyListPrint(ArrayList<Integer>[] graph, int nodes) {
        System.out.println("\nAdjacency List:\n");
        for (int i = 0; i < nodes; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j) + "\t");
            }
            System.out.println();
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No. of nodes: ");
        int nodes = sc.nextInt();
        System.out.print("No. of edges: ");
        int edges = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[100];
        for (int i = 0; i < 100; i++) {
            graph[i] = new ArrayList<>();
        }

        System.out.println("Please input " + edges + " connected nodes: ");
        for (int i = 0; i < edges; i++) {
            System.out.print((i + 1) + "th connected Edges : ");
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        adjacencyListPrint(graph, nodes);
        sc.close();
    }
}