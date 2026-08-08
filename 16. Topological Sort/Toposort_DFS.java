import java.util.*;

class Toposort_DFS {
    static final int INF = 999;
    static ArrayList<Integer>[] adjList = new ArrayList[INF];
    static int node, edge;
    static int totalTime = 0;
    static int[] discoverTime = new int[INF];
    static int[] finishTime = new int[INF];
    static String[] color = new String[INF];
    static char[] DFSSequence = new char[INF];
    static int nodeCount = 0;
    static String stepString = "";
    static ArrayList<Character> topoSequence = new ArrayList<>();

    static void adjListInput() {
        Scanner sc = new Scanner(System.in);
        node = sc.nextInt();
        edge = sc.nextInt();
        for (int i = 0; i < INF; i++) adjList[i] = new ArrayList<>();
        for (int i = 0; i < edge; i++) {
            char node1 = sc.next().charAt(0);
            char node2 = sc.next().charAt(0);
            int node1Index = Character.toLowerCase(node1) - 'a';
            int node2Index = Character.toLowerCase(node2) - 'a';
            adjList[node1Index].add(node2Index);
        }
        adjListPrint(node);
    }

    static void dfs(int source) {
        totalTime++;
        discoverTime[source] = totalTime;
        color[source] = "gray";
        if (adjList[source].isEmpty()) {
            color[source] = "black";
            finishTime[source] = totalTime;
        }
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
            } else if (color[next].equals("gray")) {
                totalTime++;
                finishTime[source] = totalTime;
                color[source] = "black";
                stepString += " Step " + totalTime + " :\n";
                stepString += " Back Visited to: " + nodeName + ", discoverTime: " + discoverTime[source]
                        + ", finishTime: " + finishTime[source] + ", node color: " + color[source] + "\n\n";
            } else if (color[next].equals("black")) {
                totalTime++;
                finishTime[source] = totalTime;
                color[source] = "black";
                stepString += " Step " + totalTime + " :\n";
                stepString += " Back Visited to: " + nodeName + ", discoverTime: " + discoverTime[source]
                        + ", finishTime: " + finishTime[source] + ", node color: " + color[source] + "\n\n";
            }
        }
        topoSequence.add(nodeName);
    }

    static void dfsVisit(int source) {
        totalTime++;
        discoverTime[source] = totalTime;
        color[source] = "gray";
        if (adjList[source].isEmpty()) {
            color[source] = "black";
            finishTime[source] = totalTime;
        }
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
            } else if (color[next].equals("gray")) {
                totalTime++;
                finishTime[source] = totalTime;
                color[source] = "black";
                stepString += " Step " + totalTime + " :\n";
                stepString += " Back Visited to: " + nodeName + ", discoverTime: " + discoverTime[source]
                        + ", finishTime: " + finishTime[source] + ", node color: " + color[source] + "\n\n";
            } else if (color[next].equals("black")) {
                totalTime++;
                finishTime[source] = totalTime;
                color[source] = "black";
                stepString += " Step " + totalTime + " :\n";
                stepString += " Back Visited to: " + nodeName + ", discoverTime: " + discoverTime[source]
                        + ", finishTime: " + finishTime[source] + ", node color: " + color[source] + "\n\n";
            }
        }
        topoSequence.add(nodeName);
    }

    static void topoSort() {
        int cycle = 1, maxTime = 0;
        for (int i = 0; i < 999; i++) color[i] = "white";
        for (int i = 0; i < node; i++) {
            if (color[i].equals("white")) {
                totalTime = 0;
                stepString += "Cycle " + cycle + ":::::\n";
                dfs(i);
                maxTime = maxTime + totalTime;
                cycle++;
            }
        }
        System.out.println("\n" + stepString + "\n");
        System.out.print("Topological Sort Sequence ");
        Collections.reverse(topoSequence);
        for (int i = 0; i < node; i++) {
            System.out.print(" -> " + topoSequence.get(i));
        }
        System.out.print("\n Final DFS visiting sequence ");
        for (int i = 0; i < nodeCount; i++) {
            System.out.print(" -> " + DFSSequence[i]);
        }
        System.out.println("\n Total DFS visiting time: " + maxTime);
    }

    static void adjListPrint(int node) {
        System.out.println("Adjacancy List: ");
        for (int i = 0; i < node; i++) {
            char listName = (char) ('a' + i);
            System.out.print(listName + " : ");
            for (int j = 0; j < adjList[i].size(); j++) {
                char listElements = (char) (adjList[i].get(j) + 'a');
                System.out.print(listElements + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        adjListInput();
        topoSort();
    }
}