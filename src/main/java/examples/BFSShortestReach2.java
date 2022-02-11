package examples;

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

1
4 2
2 3
3 4
2
 */
public class BFSShortestReach2 {
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

    private static class Graph {
        int[] outputArray;
        private int[][] nodeGraph; // holds node to node connection matrix
        int starterNode;
        private final int edgeLength = 6;
        int numberOfNodes;

        public Graph(int numberOfNodes) {
            this.numberOfNodes = numberOfNodes;
            nodeGraph = new int[numberOfNodes][numberOfNodes];
            outputArray = new int[numberOfNodes];
            for(int i=0;i<numberOfNodes;i++){
                for(int j=0;j<numberOfNodes;j++){
                    nodeGraph[i][j] = -1;
                }
            }
        }

        public void setStarterNode(int s) {
            starterNode = s;
        }

        public void addEdge(int edgeStartPt, int edgeEndPt){
            nodeGraph[edgeStartPt-1][edgeEndPt-1] = edgeLength;

            printNodeGraph();
        }

        public void printNodeGraph(){
            System.out.println();
            System.out.println("Node Graph: ");
            for(int i=0;i<numberOfNodes;i++){
                System.out.print(i+": ");
                for(int j=0;j<numberOfNodes;j++){
                    System.out.print(" "+nodeGraph[i][j]+", ");
                }
                System.out.println();
            }
            System.out.println();
        }

        public void printOutput() {
            createOutputArray();
            System.out.println("OUTPUT:");
            for(int i=0;i<numberOfNodes;i++){
                if(i!=(starterNode-1)) //ignore starter node
                    System.out.print(outputArray[i]+" ");
            }
        }

        public int getDistanceForNode(int node) {
            int[] nodeArray = nodeGraph[node];  //
            for (int i=0;i<numberOfNodes;i++){
                if (nodeArray[i]==edgeLength){
                    return edgeLength + getDistanceForNode(i);
                }
            }
            return 0;
        }

        public void createOutputArray(){
            Arrays.fill(this.outputArray,-1);
            int s = starterNode-1;
            int[] starterNodeArray = nodeGraph[s];
            printArray(starterNodeArray);
            for(int i=0;i<numberOfNodes;i++){
                printOutputArray();
                System.out.print("  i: "+i+"  ");
                if( (i!=s) && (starterNodeArray[i] == edgeLength) ){
                    this.outputArray[i] = edgeLength + getDistanceForNode(i);
                }
            }
        }

        private void printArray(int[] arr){
            System.out.print("ARRAY: ");
            for(int i=0;i<numberOfNodes;i++){
                System.out.print(arr[i]+" ");
            }
        }

        private void printOutputArray(){
            System.out.print("OUTPUT-ARRAY:");
            for(int i=0;i<numberOfNodes;i++){
                if(i!=(starterNode-1)) //ignore starter node
                    System.out.print(outputArray[i]+" ");
            }
        }

    }
}