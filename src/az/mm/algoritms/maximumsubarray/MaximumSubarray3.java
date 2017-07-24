package az.mm.algoritms.maximumsubarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MaximumSubarray3 {

    public static void main(String[] args) {
        int[] arr = {12, -7, -3, -3, 12, -1, -8, -4, 6, -3, 4, 5, -7, 9, -2};
        int maxSum = Integer.MIN_VALUE, sum = 0;
        int left = 0, right = 0, next = 0;

        for (int i = 0, length = arr.length; i < length; i++) {
            sum += arr[i];

            if (next == i) System.out.print("[" + next + ".. ");
            
            if (maxSum < sum) {
                maxSum = sum;
                left = next;
                right = i;
            }
            if (sum < 0) {
                sum = 0;
                next = i + 1;
                System.out.println(i + "] maxSum: " + maxSum);
            }
        }
        System.out.println(arr.length - 1 + "] maxSum: " + maxSum);
        System.out.printf("\n[%d.. %d] maxSum: %d <-- maximum subarray\n", left, right, maxSum);
        //        System.out.println("\n[" + left + ".. " + right + "] maxSum: " + maxSum + " <-- maximum subarray");
    }
    
    

}

