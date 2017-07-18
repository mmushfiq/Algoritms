package az.mm.algoritms.test;

import az.mm.algoritms.MaximumSubarray;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    
    public static void main(String[] args) {
        testMaxSubarray();
    }
    
    static void testMaxSubarray(){
//        int arr[] = createIntArrayFromList(50, 50, -50);
        int arr[] = {-2, 3, -1, 5, /*middle*/ -2, -1, -5, -2};
        printArr(arr);
        System.out.println("-------");
        
        System.out.println("\n----findMaximumSubarray recursive----");
        printArr(MaximumSubarray.findMaximumSubarray(arr, 0, arr.length-1));
        
        System.out.println("\n----findMaxCrossingSubarray length-1 ----");
        printArr(MaximumSubarray.findMaxCrossingSubarray(arr, 0, arr.length/2, arr.length-1));
        
        System.out.println("\n----findMaxCrossingSubarray length----");
        printArr(MaximumSubarray.findMaxCrossingSubarray(arr, 0, arr.length/2, arr.length));
        
        System.out.println("\n----findMaximumSubarray----");
        MaximumSubarray.findMaximumSubarray(arr);
        
//        System.out.println("---sort----");
//        Arrays.sort(arr);
//        printArr(arr);
    }
    
    
    public static int[] createIntArray(int length, int maxValue, int minValue){
        int[] arr = new int[length];
        for(int i=0; i<length; i++){
            int random = new Random().nextInt((maxValue - minValue) + 1) + minValue;
            int random2 = new Random().nextInt(9) + 1;
            arr[i] =  random-random2;
        }
        System.out.println("Massiv yaradildi");
       
        return arr;
    }
    
    
    public static int[] createIntArrayFromList(int length, int maxValue, int minValue){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<length; i++){
            int random = new Random().nextInt((maxValue - minValue) + 1) + minValue;
            int random2 = new Random().nextInt(9) + 1;
            int value = random + random2;
            if(!list.contains(value)) list.add(value);
        }
        int[] arr = list.stream().mapToInt(i->i).toArray();
        System.out.println("Massiv yaradildi");
       
        return arr;
    }
    
    
    private static void printArr(int[] arr){
        for(int i=0, length=arr.length-1; i <= length; i++ )
            System.out.println("index["+i+"] = " + arr[i]);
    }
}
