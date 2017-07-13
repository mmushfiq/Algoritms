package az.mm.algoritms.sort;

import java.util.Arrays;

public class Insertion {

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 9, 1, 4, 6, 2, 8, 7};
        int[] arr2 = {3, 5, 9, 1, 4, 6, 2, 8, 7};
        myInsertionSort(arr1);
        jdkInsertionSort(arr2);
        
        System.out.println("mine: " + Arrays.toString(arr1) + "\n"+
                           "jdk:  " + Arrays.toString(arr2));    
    }
    
    public static void myInsertionSort(int[] arr){
        int current, previous;
        for (int i = 1, length = arr.length; i < length; i++) {
            current = arr[i];
            for (int j = i-1; j >= 0; j--) {
                previous = arr[j];
                if (current < previous) {
                    arr[j+1] = previous;
                    arr[j] = current;
                } else break;
            }
        }
    }
    
    public static void jdkInsertionSort(int[] a){
        for (int i = 0, j = i, right = a.length-1; i < right; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == 0) break;
            }
            a[j + 1] = ai;
        }
    }
    
}
