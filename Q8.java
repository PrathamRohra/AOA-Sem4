import java.util.*;
//FLOYD WARSHALL 
public class Q8 {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int graph[][] = { { 0, 5, INF, 10 },
                          { INF, 0, 3, INF },
                          { INF, INF, 0, 1 },
                          { INF, INF, INF, 0 } };
        floydWarshall(graph);
    }

    static void floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        int[][] pi = new int[n][n];

        // Initialize dist and pi arrays
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    pi[i][j] = i;
                } else {
                    pi[i][j] = -1;
                }
            }
        }

        // Run Floyd Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        pi[i][j] = pi[k][j];
                    }
                }
            }
        }

        // Print final dist matrix
        System.out.println("Final D matrix:");
        printMatrix(dist);

        // Print final pi matrix
        System.out.println("Final Pi matrix:");
        printMatrix(pi);

    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(matrix[i][j] + "   ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
