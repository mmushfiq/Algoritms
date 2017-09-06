package az.mm.algoritms;

public class FloydWarshall4 {

    final static int X = 99999, N = 4;

    public static void main(String[] args) {

        // given adjacency representation of matrix
        int adjMatrix[][] = {
                    {0, X, -2, X},
                    {4, 0, 3, X},
                    {X, X, 0, 2},
                    {X, -1, X, 0}
                };

        // Run Floyd Warshell algorithm
        new FloydWarshall4().FloydWarshell(adjMatrix);

    }

// Recurive Function to print path of given 
// vertex u from source vertex v
    void printPath(int path[][], int v, int u) {
        if (path[v][u] == v) return;

        printPath(path, v, path[v][u]);
        System.out.print(path[v][u] + " ");
    }

    void printSolution(int cost[][], int path[][]) {
        for (int v = 0; v < N; v++) {
            for (int u = 0; u < N; u++) {
                if (cost[v][u] == X) {
                    System.out.println("X");
                } else {
                    System.out.print(cost[v][u] + " ");
                }
            }
            System.out.println("");
        }

        System.out.println("");

        for (int v = 0; v < N; v++) {
            for (int u = 0; u < N; u++) {
                if (u != v && path[v][u] != -1) {
                    System.out.print("\nShortest Path from vertex " + v + " to vertex " + u + " is (" + v + " ");
                    printPath(path, v, u);
                    System.out.print(u + ") ");
                }

            }
        }
    }

// Function to run Floyd-Warshell algorithm
    void FloydWarshell(int adjMatrix[][]) {
	// cost[] and parent[] stores shortest-path 
        // (shortest-cost/shortest route) information
        int cost[][] = new int[N][N], path[][] = new int[N][N];
        


        // initialize cost[] and parent[]
        for (int v = 0; v < N; v++) {
            for (int u = 0; u < N; u++) {
			// initally cost would be same as weight 
                // of the edge
                cost[v][u] = adjMatrix[v][u];

                if (v == u) {
                    path[v][u] = 0;
                } else if (cost[v][u] != X) {
                    path[v][u] = v;
                } else {
                    path[v][u] = -1;
                }
            }
        }

        // run Floyd-Warshell
        for (int k = 0; k < N; k++) {
            for (int v = 0; v < N; v++) {
                for (int u = 0; u < N; u++) {
				// If vertex k is on the shortest path from v to u,
                    // then update the value of cost[v][u], path[v][u]

                    if (cost[v][k] != X && cost[k][u] != X
                            && cost[v][k] + cost[k][u] < cost[v][u]) {
                        cost[v][u] = cost[v][k] + cost[k][u];
                        path[v][u] = path[k][u];
                    }
                }

			// if diagonal elements become negative, the
                // graph contains a negative weight cycle
                if (cost[v][v] < 0) {
                    System.out.println("Negative Weight Cycle Found!");
                    return;
                }
            }
        }

        // Print the shortest path between all pairs of vertices
        printSolution(cost, path);
    }
}
