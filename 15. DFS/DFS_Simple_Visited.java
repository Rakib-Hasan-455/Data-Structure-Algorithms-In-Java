import java.util.*;

class DFS_Simple_Visited {
    static ArrayList<Integer>[] graph = new ArrayList[555];
    static boolean[] visited = new boolean[555];

    static void dfs(int source) {
        visited[source] = true;
        for (int i = 0; i < graph[source].size(); i++) {
            int next = graph[source].get(i);
            if (!visited[next])
                dfs(next);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 555; i++) graph[i] = new ArrayList<>();

        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        int source = sc.nextInt();
        dfs(source);

        for (int i = 0; i < nodes; i++) {
            if (visited[i]) {
                System.out.println("Node " + i + " is visited.");
            } else {
                System.out.println("Node " + i + " is not visited");
            }
        }
        sc.close();
    }
}