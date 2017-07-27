package az.mm.algoritms;

import java.util.Arrays;

public class LonelyInteger {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2, 4, 3};
        
        /*
        //test uchun
        arr = new int[]{1, 1, 2};
        arr = new int[]{0, 0, 1, 2, 1};
        arr = new int[]{4, 5, 7, 6, 4, 7, 5, 8, 8};
        */
        
        System.out.println(getLonelyInteger2(arr));
    }

    public static int getLonelyInteger(int[] arr) {
        int unique = 0;
        for (int i : arr) 
            unique ^= i;
        
        return unique;
    }
    
    
    public static int getLonelyInteger2(int[] arr) {
        int unique = 0;
        System.out.print("0(000)");  // unique
        for (int i : arr){ 
            System.out.print(" ^ " + i + "(");
            System.out.print(String.format("%3s", Integer.toBinaryString(i)).replace(" ", "0") + ")");
            unique ^= i;
        } 

        return unique;
    } 
    
public static int getLonelyInteger22(int[] arr) {
    int unique = 0;
    System.out.print(unique + "("+Integer.toBinaryString(unique)+")");
    for (int i : arr){ 
        System.out.print(" ^ " + i + "("+Integer.toBinaryString(i)+")");
        unique ^= i;
    } 

    return unique;
} 
    
    
    public static int getLonelyInteger3(int[] arr) {
        int unique = 0;
        int[] k = new int[100];
        for (int i=0; i<arr.length; i++)
            k[arr[i]]++;
        
        for (int i=0; i<k.length; i++) 
            if(k[i] == 1) return i;
        
        return unique;
    }
    
}
