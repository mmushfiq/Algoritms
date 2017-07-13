package az.mm.algoritms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Insertion_COPY {
    int[] arr1, arr2;

    public static void main(String[] args) {
        List list = new ArrayList<>();
        
        int max = 1_000_001, min = 1;
        int[] arr1 = new int[max];
        for(int i=0; i<max; i++){
            int random = new Random().nextInt((max - min) + 1) + min;
            arr1[i] = random;
            list.add(random);
        }

//        Collections.sort(list);
//        Arrays.sort(arr1);
//        MergeSort.sort(arr1);
        BubbleSort.sort(arr1);
        
        
        System.out.println(Arrays.toString(arr1));
        
        
        
//        int[] arr = {3, 5, 9, 1, 4, 6, 2, 8, 7};
//        int[] arr1 = {3, 5, 9, 1, 4, 6, 2, 8, 7};
//        insertionSort(arr);
//        Arrays.sort(arr1);
//        javaSort(arr1);
        
        
    /*
        int current, previous;
        for (int i = 1; i < arr.length; i++) {
            System.out.println("i arr["+i+"] = "+arr[i]);
            current = arr[i];
            for (int j = i-1; j >= 0; j--) {
                System.out.println("\t j arr["+j+"] = "+arr[j]);
                previous = arr[j];
                if (current < previous) {
                    System.out.println("\t if");
                    
                    arr[j+1] = previous;
                    arr[j] = current;
                }
            }
        }
    */
        
//        System.out.println("mine: "+Arrays.toString(arr));
//        System.out.println("java: "+Arrays.toString(arr));    
        
//        Insertion_COPY i = new Insertion_COPY();
//        i.createArray();
//        
//        i.insertionSortTest();
//        i.javaSortTest();
    }
    
    public static void myInsertionSort(int[] arr){
        int current, previous;
        for (int i = 1; i < arr.length; i++) {
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
    
    
//-------------------------------------------------------------------------
    
    public void insertionSortTest(){
        long start = System.currentTimeMillis();
        int[] arr = arr2;
//        int count = 0;
        int current, previous;
        for (int i = 1; i < arr.length; i++) {
            current = arr[i];
            for (int j = i-1; j >= 0; j--) {
//                count++;
                previous = arr[j];
                if (current < previous) {
                    arr[j+1] = previous;
                    arr[j] = current;
                } else break;
            }
        }
        long end = System.currentTimeMillis()-start;
        System.out.println("my sort time: " + end);
//        System.out.println("insertionSort: "+count);  //36
    }
    
    public void javaSortTest(){
        long start = System.currentTimeMillis();
        int[] a = arr1;
//        int count = 0;
        for (int i = 0, j = i, right = a.length-1; i < right; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
//                count++;
                a[j + 1] = a[j];
                if (j-- == 0) break;
                
            }
            a[j + 1] = ai;
        }
        long end = System.currentTimeMillis()-start;
        System.out.println("java sort time: " + end);
//        System.out.println("javasort: "+count);  //14
    }
    
    public void createArray(){
        int max=300000, min=1;
        arr1 = new int[max];
        arr2 = new int[max];
        for(int i=0; i<max; i++){
            int random = new Random().nextInt((max - min) + 1) + min;
            arr1[i] =  random;
            arr2[i] = random;
            
            if(i<15){
                System.out.println(arr1[i]+" "+arr2[i]);
            }
        }
        System.out.println("Massivler yaradildi");
       
    }
}
