package az.mm.algoritms;

import java.util.Scanner;

public class Evklid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println("ƏBOB: " + ebob(a, b));
        System.out.println("ƏKOB: " + ekob(a, b));
    }

    static int ebob(int a, int b) {
        if (a % b == 0) return b;
       return ebob(b, a % b);
    }

    static int ekob(int a, int b) {
        return a * b / ebob(a, b);
    }
}
