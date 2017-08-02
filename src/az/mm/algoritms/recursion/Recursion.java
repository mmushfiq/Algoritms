package az.mm.algoritms.recursion;

public class Recursion {
    
    private Recursion r1 = new Recursion();
    private int a = 5;

    public Recursion() {
        r1.a = 3;
    }
    
    public static void main(String[] args) {
        Recursion r2 = new Recursion();
        System.out.println(r2.a);
    }
}
