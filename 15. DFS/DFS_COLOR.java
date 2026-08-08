import java.util.*;

class DFS_COLOR {
    static final int INF = 999;
    static ArrayList<Integer>[] adjList = new ArrayList[INF];
    static boolean[] visited = new boolean[INF];
    static int node, edge;
    static int totalTime = 0;
    static int[] discoverTime = new int[INF];
    static int[] finishTime = new int[INF];
    static String[] color = new String[INF];
    static char[] DFSSequence = new char[INF];
    static int nodeCount = 0;
    static String stepString = "";

    static void adjListInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Number of node: ");
        node = sc.nextInt();
        System.out.println(" Number of edge: ");
        edge = sc.nextInt();
        System.out.println(" Enter connected nodes: ");
        for (int i = 0; i < INF; i++) adjList[i] = new ArrayList<>();
        for (int i = 0; i < edge; i++) {
            char node1 = sc.next().charAt(0);
            char node2 = sc.next().charAt(0);
            int node1Index = Character.toLowerCase(node1) - 'a';
            int node2Index = Character.toLowerCase(node2) - 'a';
            adjList[node1Index].add(node2Index);
            adjList[node2Index].add(node1Index);
        }
        adjListPrint(node);
    }

    static void dfs(int source) {
        for (int i = 0; i < 999; i++) color[i] = "white";
        totalTime++;
        discoverTime[source] = totalTime;
        color[source] = "gray";

        char nodeName = (char) (source + 'a');
        DFSSequence[nodeCount++] = nodeName;

        stepString += " Step " + totalTime + " :\n";
        stepString += " Visited: " + nodeName + ", discoverTime: " + discoverTime[source]
                + ", finishTime: " + finishTime[source] + ", node color: " + color[source] + "\n\n";

        for (int i = 0; i < adjList[source].size(); i++) {
            int next = adjList[source].get(i);
            if (color[next].equals("white")) {
                dfsVisit(next);
                totalTime++;
                finishTime[source] = totalTime;
                color[source] = "black";
                stepString += " Step " + totalTime + " :\n";
                stepString += " Back Visited to: " + nodeName + ", discoverTime: " + discoverTime[source]
                        + ", finishTime: " + finishTime[source] + ", node color: " + color[source] + "\n\n";
            }
        }
    }

    static void dfsVisit(int source) {
        totalTime++;
        discoverTime[source] = totalTime;
        color[source] = "gray";

        char nodeName = (char) (source + 'a');
        DFSSequence[nodeCount++] = nodeName;

        stepString += " Step " + totalTime + " :\n";
        stepString += " Visited: " + nodeName + ", discoverTime: " + discoverTime[source]
                + ", finishTime: " + finishTime[source] + ", node color: " + color[source] + "\n\n";

        for (int i = 0; i < adjList[source].size(); i++) {
            int next = adjList[source].get(i);
            if (color[next].equals("white")) {
                dfsVisit(next);
                totalTime++;
                finishTime[source] = totalTime;
                color[source] = "black";
                stepString += " Step " + totalTime + " :\n";
                stepString += " Back Visited to: " + nodeName + ", discoverTime: " + discoverTime[source]
                        + ", finishTime: " + finishTime[source] + ", node color: " + color[source] + "\n\n";
            }
        }
    }

    static void DFSSequencePrint() {
        System.out.println("\n" + stepString + "\n");
        System.out.print(" Final DFS visiting sequence ");
        for (int i = 0; i < nodeCount; i++) {
            System.out.print(" -> " + DFSSequence[i]);
        }
        System.out.println("\n Total DFS visiting time: " + totalTime);
    }

    static void adjListPrint(int node) {
        System.out.println("\n Adjacancy List: ");
        for (int i = 0; i < node; i++) {
            char listName = (char) ('a' + i);
            System.out.print(" " + listName + " : ");
            for (int j = 0; j < adjList[i].size(); j++) {
                char listElements = (char) (adjList[i].get(j) + 'a');
                System.out.print(listElements + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        adjListInput();
        dfs(0);
        DFSSequencePrint();
    }
}