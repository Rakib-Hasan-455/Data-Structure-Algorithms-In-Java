import java.util.*;

class BellmanFord {
    static final int INF = 999;
    static int[] distance = new int[INF];
    static char[] shortestPath = new char[INF];
    static ArrayList<Pair>[] adjListPair = new ArrayList[INF];
    static int node, edge;
    static boolean updated;

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

    static void bellmanFord(int source) {
        for (int i = 0; i < INF; i++) distance[i] = INF;
        distance[source] = 0;
        shortestPath[source] = (char) (source + 'a');

        for (int i = 0; i < node - 1; i++) {
            System.out.println("\nRound " + (i + 1) + ":");
            updated = false;
            for (int j = 0; j < node; j++) {
                for (int k = 0; k < adjListPair[j].size(); k++) {
                    int parentNodeU = j;
                    int parentDestU = distance[j];
                    int childNodeV = adjListPair[j].get(k).first;
                    int childDestV = adjListPair[j].get(k).second;
                    char node1Name = (char) (parentNodeU + 'a');
                    char node2Name = (char) (childNodeV + 'a');
                    System.out.println(" if((parentDestU(" + node1Name + ") + childDestV(" + node2Name + ") = "
                            + parentDestU + " + " + childDestV + " = " + (parentDestU + childDestV)
                            + ") < (destance previous childNodeV(" + node2Name + ") = " + distance[childNodeV] + "))");
                    if (((parentDestU + childDestV) < distance[childNodeV])) {
                        distance[childNodeV] = parentDestU + childDestV;
                        shortestPath[childNodeV] = (char) (childNodeV + 'a');
                        System.out.println(" = Yes, Updated destance current childNodeV(" + node2Name + ") = " + distance[childNodeV]);
                        updated = true;
                    } else {
                        System.out.println(" = No, No update on childNodeV(" + node1Name + ") ");
                    }
                }
            }
            if (!updated) {
                break;
            }
        }

        if (relaxOneMore()) {
            System.out.println("Negative cycle exists!");
            return;
        }

        System.out.println("\n Minimum Distance of all nodes: ");
        for (int i = 0; i < node; i++) {
            char nodeName = (char) (i + 'a');
            System.out.println(" " + nodeName + " node Distance = " + distance[i]);
        }
        System.out.print("shortestPath ");
        for (int i = 0; i < node; i++) {
            int shortestPathIndex = shortestPath[i] - 'a';
            System.out.print(" -> (" + shortestPath[i] + ", " + distance[shortestPathIndex] + ")");
        }
    }

    static boolean relaxOneMore() {
        if (updated) System.out.println("relaxOneMore executed!");
        for (int j = 0; j < node && updated; j++) {
            for (int k = 0; k < adjListPair[j].size(); k++) {
                int parentNodeU = j;
                int parentDestU = distance[j];
                int childNodeV = adjListPair[j].get(k).first;
                int childDestV = adjListPair[j].get(k).second;
                if (((parentDestU + childDestV) < distance[childNodeV])) {
                    distance[childNodeV] = parentDestU + childDestV;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        adjListPairInput();
        Scanner sc = new Scanner(System.in);
        char source = sc.next().charAt(0);
        int sourceIndex = Character.toLowerCase(source) - 'a';
        bellmanFord(sourceIndex);
    }
}