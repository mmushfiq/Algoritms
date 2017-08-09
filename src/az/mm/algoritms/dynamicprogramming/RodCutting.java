package az.mm.algoritms.dynamicprogramming;

public class RodCutting {

    public static void main(String[] args) {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30}; //price
        p = new int[] {1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(cutRod(p, p.length));
    }

    // complexity - T(n) = 2^n
    public static int cutRod(int[] p, int n) {
        if (n == 0) return 0;
        
        int q = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) 
            q = Integer.max(q, p[i] + cutRod(p, n-i-1));
        
        return q;
    }

}
