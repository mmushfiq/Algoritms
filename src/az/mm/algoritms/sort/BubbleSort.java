package az.mm.algoritms.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] testArray = {3, 5, 9, 1, 4, 6, 2, 8, 7};
        sort2(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    public static void sort(int arr[]) {
        int temp, count = 0, perf = 0;
        while (count++ < arr.length - 1) {
            for (int i = 0; i < arr.length - count/*arr.length-1*/; i++) {
                perf++;
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;

                    /*
                     //ashagidaki kod elave deyishen yaratmadan menimsetmedir.. bunu da maraq uchun blogda elave daxil etmek olar..
                     arr[i+1] = arr[i+1] + arr[i];
                     arr[i] = arr[i+1] - arr[i];
                     arr[i+1] = arr[i+1] - arr[i];
                     */
                }
            }
        }
        System.out.println("performance: " + perf);
    }

    public static void sort2(int arr[]) {
        int temp, perf = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length-1; j >= i + 1; j--) {
                perf++;
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            
        }
        System.out.println("performance: " + perf);
    }
}
