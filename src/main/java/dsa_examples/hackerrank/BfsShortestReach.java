package dsa_examples.hackerrank;

import java.util.*;

/*
Input Format

The first line contains an integer, q, the number of queries.

Each of the following q sets of lines is as follows:

The first line contains two space-separated integers, n and m, the number of nodes and the number of edges.
Each of the next m lines contains two space-separated integers, u and v, describing an edge connecting node  to node .
The last line contains a single integer, s, the index of the starting node.

Output Format

For each of the queries, print a single line of space-separated integers denoting the shortest distances to each
of the  other nodes from starting position. These distances should be listed sequentially by node number (i.e., ),
but should not include node . If some node is unreachable from , print  as the distance to that node.

Sample Input

2
4 2
1 2
1 3
1
3 1
2 3
2
 */
public class BfsShortestReach {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int numberOfQueries = sc.nextInt(); //first line is number of queries
        System.out.println("Number of queries: "+numberOfQueries);
        for(int query=0; query < numberOfQueries; query++) {

            System.out.println("For query "+query);
            sc.nextLine();
            int nodes = sc.nextInt();
            int edges = sc.nextInt();

            System.out.println("Nodes: "+nodes);
            System.out.println("Edges: "+edges);
            Graph g = new Graph(nodes);

            for(int edge=0; edge < edges; edge++) {
                sc.nextLine();

                System.out.println("For Edge "+edge);
                int edgeStartPoint = sc.nextInt();
                int edgeEndPoint = sc.nextInt();
                System.out.println("Edge St: "+edgeStartPoint);
                System.out.println("Edge end: "+edgeEndPoint);
                g.addEdge(edgeStartPoint,edgeEndPoint);
            }
            sc.nextLine();

            System.out.println("Enter starter node: ");
            int starterNode = sc.nextInt(); // last line
            g.setStarterNode(starterNode);

            g.printOutput();

            System.out.println();
        }
    }
}


class Graph {
    private final int[] outputArray; // holds distances of n-1 nodes apart from start node
    private final Map<Integer,List<Integer>> nodeEdgeMap = new HashMap<>(); // holds List of edge endpoints for a node
    int starterNode;
    private final int edgeLength = 6;
    int numberOfNodes;

    public Graph(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        outputArray = new int[numberOfNodes-1];
        Arrays.fill(outputArray, -1); // fill all positions with -1
    }

    public void setStarterNode(int s) {
        starterNode = s;
    }

    public void addEdge(int edgeStartPt, int edgeEndPt){
        List<Integer> edges;
        if (nodeEdgeMap.containsKey(edgeStartPt) && nodeEdgeMap.get(edgeStartPt) != null){
            edges = nodeEdgeMap.get(edgeStartPt);
        } else {
            edges = new ArrayList<>();
        }
        edges.add(edgeEndPt);
        nodeEdgeMap.put(edgeStartPt,edges);

        printNodeEdgeMap();
    }

    public void printNodeEdgeMap(){
        //System.out.println();
        //System.out.println("NODE EDGE MAP: ");
        for(Integer node : nodeEdgeMap.keySet()){
          //  System.out.print("Node: "+node+", {");
            List<Integer> edges = nodeEdgeMap.get(node);
            //    System.out.print("["+edge+"]");
            //System.out.print("}");
            //System.out.println();
        }
        //System.out.println();
    }

    public int[] createOutput(int starterNode, int edgeLength, int[] outputArray) {
        // 1. Get edges for starter node
        //printNodeEdgeMap();
        if(!nodeEdgeMap.containsKey(starterNode)){
            return outputArray; // no edge starting with current node
        }
        System.out.println("For Starter Node: "+starterNode);
        List<Integer> starterNodeEdges = nodeEdgeMap.get(starterNode);

        // 2. Fill output Array with edgeDistance for endnodes of starter node edges
        for (Integer endNode : starterNodeEdges) {
            outputArray[endNode - 2] = edgeLength;
            System.out.println("outputArray: "+Arrays.toString(outputArray));
            outputArray = createOutput(endNode, edgeLength+this.edgeLength, outputArray);
        }
        return outputArray;
    }

    public void printOutput() {
        int[] outputArray = createOutput(starterNode, edgeLength, this.outputArray);

        // 4. Update distance of
        System.out.println("Distance array: ");
        for (int j : outputArray) {
            System.out.print(j + " ");
        }
    }
}