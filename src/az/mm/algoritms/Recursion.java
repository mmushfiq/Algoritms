package az.mm.algoritms;

public class Recursion {

    public static void main(String[] args) {
        printDesc(10);
        System.out.println();
        printAsc(10);
    }

    static void printDesc(int a) {
        System.out.print(a + " ");
        if (a > 1) printDesc(a - 1);
    }

    static void printAsc(int a) {
        if (a > 1) printAsc(a - 1);
        System.out.print(a + " ");
    }
}
