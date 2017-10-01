package az.mm.algoritms.recursion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(7));
    }

    static long factorial(int n) {
        if (n <= 1) return 1;
       return n * factorial(n - 1);
    }
    
    
}
