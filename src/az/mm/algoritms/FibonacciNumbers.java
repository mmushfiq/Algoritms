package az.mm.algoritms;

public class FibonacciNumbers {
    public static void main(String[] args) {
        for(int i=1; i<=10; i++) 
            System.out.print(fibonacci(i)+" ");
        
        fibonacci2(10);
    }
    
    public static int fibonacci(int n){
        if(n==1 || n==2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public static void fibonacci2(int n){
        int number = 1;
        if(n==1 || n==2) return;
//        number = fibonacci(n-1) + fibonacci(n-2);
        System.out.println(fibonacci(n-1) + fibonacci(n-2));
    }
    
}
