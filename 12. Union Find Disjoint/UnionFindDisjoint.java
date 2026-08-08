import java.util.*;

class UnionFindDisjoint {
    static ArrayList<Integer> dsuf = new ArrayList<>();

    static int findRoot(int v) {
        if (dsuf.get(v) == -1)
            return v;
        return findRoot(dsuf.get(v));
    }

    static void checkConnection(int node1, int node2) {
        int node1Root = findRoot(node1);
        int node2Root = findRoot(node2);
        if (node1Root == node2Root) {
            System.out.println("They are Connected!");
        } else {
            System.out.println("They are not connected!");
        }
    }

    static void unionOp(int node1, int node2) {
        int node1Root = findRoot(node1);
        int node2Root = findRoot(node2);
        dsuf.set(node1Root, node2Root);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int V = sc.nextInt();

        for (int i = 0; i < V + 10; i++) dsuf.add(-1);

        for (int i = 0; i < E; ++i) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            unionOp(node1, node2);
        }

        while (true) {
            System.out.print("Enter search node: ");
            int searchRoot = sc.nextInt();
            System.out.println("Root node of " + searchRoot + " = " + findRoot(searchRoot));

            System.out.print("Check connection node1: ");
            int node1 = sc.nextInt();
            System.out.print("Check connection node2: ");
            int node2 = sc.nextInt();
            checkConnection(node1, node2);
        }
    }
}