package az.mm.algoritms.dynamicprogramming;

//dinamik proqramlasdirma ile xeyli performansi artirmaq olur
import java.util.Scanner;

public class FibonacciNumbers {
    final static int NIL = -1;
    static int lookup[]; 
    
    private static void createMemoizedArray(int n){
        lookup = new int[n+1];
        for (int i = 0; i <= n; i++) {
            lookup[i] = NIL;
        }
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        createMemoizedArray(n);
        for (int i = 1; i <= n; i++) {
//            System.out.print(fibonacci(i) + " ");
            System.out.print(fib(i) + " ");
//            System.out.print(fib2(i) + " ");
        }
    }

    //naive method
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }



    /* Memoized version */
    static int fib(int n) {
        if (lookup[n] == NIL) {
            if (n <= 1) 
                lookup[n] = n;
             else 
                lookup[n] = fib(n - 1) + fib(n - 2);
        }
        return lookup[n];
    }

    // Tabulated version
    static int fib2(int n) {
        int f[] = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

}
