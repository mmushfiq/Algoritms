package az.mm.algoritms;

import java.util.Scanner;

public class TrianglePrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        
        int j=1, i, count=0;
        while(j <= max){
            i=1; count++;
            while(i++ <= count && j <= max)
                System.out.print(j++ + "\t");
            System.out.println("");
        }
    }
}
