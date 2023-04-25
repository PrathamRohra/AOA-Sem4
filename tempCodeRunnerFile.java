//FLOYD WARSHAL
import java.util.*;
public class Q8 {
    final static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int graph[][] = { { 0, 5, INF, 10 },
                          { INF, 0, 3, INF },
                          { INF, INF, 0, 1 },
                          { INF, INF, INF, 0 } };
        
 
        // Function call
        System.out.println("Graph Len: "+graph.length);
        floydWarshall(graph);
    }
    static void floydWarshall(int[][] graph){

        for(int k = 0; k < graph.length; k++){
            for(int i = 0; i < graph.length; i++){
                for(int j = 0; j < graph.length; j++){
                    if (graph[i][k] + graph[k][j]< graph[i][j])
                        graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }

        System.out.println("Printing the matrix: ");
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                if (graph[i][j] == INF)
                System.out.print("INF ");
            else
                System.out.print(graph[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
