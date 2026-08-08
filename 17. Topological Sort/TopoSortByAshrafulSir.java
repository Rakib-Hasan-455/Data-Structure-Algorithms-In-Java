import java.util.*;

class TopoSortByAshrafulSir {
    static ArrayList<Integer>[] graph = new ArrayList[15];
    static int[] start = new int[15];
    static int[] finish = new int[15];
    static int T = 0;

    static void DFS(int u) {
        ++T;
        start[u] = T;

        for (int i = 0; i < graph[u].size(); i++) {
            int v = graph[u].get(i);
            if (start[v] == 0) {
                DFS(v);
            }
        }

        ++T;
        finish[u] = T;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 15; i++) graph[i] = new ArrayList<>();

        int node = sc.nextInt();
        int edge = sc.nextInt();

        for (int i = 1; i <= edge; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
        }

        for (int i = 1; i <= node; i++) {
            int m = graph[i].size();
            System.out.print("Adjacency List of Node " + i + ": ");
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i].get(j) + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= node; i++) {
            if (finish[i] == 0) DFS(i);
        }

        ArrayList<Pair> dag = new ArrayList<>();
        for (int i = 1; i <= node; i++) {
            dag.add(new Pair(finish[i], i));
        }

        Collections.sort(dag, (a, b) -> Integer.compare(b.first, a.first));

        for (int i = 0; i < dag.size(); i++) {
            System.out.println(dag.get(i).second + " ***** " + dag.get(i).first);
        }

        for (int i = 1; i <= node; i++) {
            System.out.println("For " + i + "th node Start Time = " + start[i] + " and Finish Time = " + finish[i]);
        }
        sc.close();
    }

    static class Pair {
        int first, second;
        Pair(int f, int s) { first = f; second = s; }
    }
}