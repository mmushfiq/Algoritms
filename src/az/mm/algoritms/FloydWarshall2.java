package az.mm.algoritms;

class FloydWarshall2 {

    final static int X = 99999, V = 4;

    void floydWarshall(int graph[][]) {
        int distance[][] = new int[V][V];
        int i, j, k;

        //initialize
        for (i = 0; i < V; i++) 
            for (j = 0; j < V; j++) 
                distance[i][j] = graph[i][j];
            

        for (k = 0; k < V; k++) 
            for (i = 0; i < V; i++) 
                for (j = 0; j < V; j++) 
                    if (distance[i][k] + distance[k][j] < distance[i][j]) 
                        distance[i][j] = distance[i][k] + distance[k][j];

        printSolution(distance);
    }

    void printSolution(int dist[][]) {
        System.out.println("Following matrix shows the shortest distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) 
                if (dist[i][j] == X) 
                    System.out.print("X ");
                else 
                    System.out.print(dist[i][j] + " ");
                
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int graph[][] = {{0, 5, X, 10},
                         {X, 0, 3, X},
                         {X, X, 0, 1},
                         {X, X, X, 0}
                        };
        FloydWarshall2 a = new FloydWarshall2();

        a.floydWarshall(graph);
    }
}

