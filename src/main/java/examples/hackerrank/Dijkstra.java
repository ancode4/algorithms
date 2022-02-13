package examples.hackerrank;
/*
    Use array for holding distance values for index i which represents vertex

 */
public class Dijkstra {
    // A utility function to print the constructed distance array
    private static void printSolution(int[] dist)
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
    public static void main(String[] args) {
        // create graph array from graph - each element array represents each vertex
        // each element inside array represents distance of directly connecting vertex from index vertex
        // represent non-connecting nodes by 0
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };
        int numberOfVertices = 9;

        int[] dist = new int[numberOfVertices]; // dist will hold distance of each vertex from source vertex

        boolean[] visitedVertices = new boolean[numberOfVertices]; // holds true if vertex has been visited

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < numberOfVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            visitedVertices[i] = false;
        }
        dist[0] = 0; // for source vertex, dist is always 0


        for(int i=0; i<numberOfVertices; i++){
            // 1. pick the closest vertex from the set of vertices which are NOT YET PROCESSED

            int closestVertex = -1;
            int closestVertexDistance = Integer.MAX_VALUE;
            for(int vertex=0; vertex < numberOfVertices; vertex++){
                if(!visitedVertices[vertex] && dist[vertex] < closestVertexDistance) {
                    closestVertexDistance = dist[vertex];
                    closestVertex = vertex;
                }
            }

            // update vertex as visited
            visitedVertices[closestVertex] = true;

            // 2. Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < numberOfVertices; v++) {
                // Update dist[v] only if is not in sptSet && there is an
                // edge from u to v && dist of picked vertex from source is not infinity
                // && and total weight of path from src to v through u is smaller than current value of dist[v]
                if(!visitedVertices[v] && graph[closestVertex][v] != 0
                        && dist[closestVertex] != Integer.MAX_VALUE
                                && dist[closestVertex] + graph[closestVertex][v] < dist[v] ){
                    dist[v] = dist[closestVertex] + graph[closestVertex][v];
                }
            }
        }

        printSolution(dist);
    }
}
