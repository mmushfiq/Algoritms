package az.mm.algoritms;

/**
 *
 * @author MM <mushfiqazeri@gmail.com>
 */
public class FloydWarshall3 {
    
    final static int X = 99999, V = 4;
    
    public static void main(String[] args) {
                int graph[][] = {{0, 5, X, 10},
                         {X, 0, 3, X},
                         {X, X, 0, 1},
                         {X, X, X, 0}
                        };
        FloydWarshall3 a = new FloydWarshall3();

        a.floydWarshall(graph);
    }

    public static int[][] floydWarshall(int[][] d) {
        int[][] p = constructInitialMatixOfPredecessors(d);
        for (int k = 0; k < d.length; k++) {
            for (int i = 0; i < d.length; i++) {
                for (int j = 0; j < d.length; j++) {
                    if (d[i][k] == Integer.MAX_VALUE || d[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }

                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                        p[i][j] = p[k][j];
                    }

                }
            }
        }
        return p;
    }

    private static int[][] constructInitialMatixOfPredecessors(int[][] d) {
        int[][] p = new int[d.length][d.length];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length; j++) {
                if (d[i][j] != 0 && d[i][j] != Integer.MAX_VALUE) {
                    p[i][j] = i;
                } else {
                    p[i][j] = -1;
                }
            }
        }
        return p;
    }
    
}
