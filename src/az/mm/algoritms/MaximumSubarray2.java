package az.mm.algoritms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MaximumSubarray2 {

    public static void main(String[] args) {
//        int[] change = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        findMaximumSubarrayWithSimpleWay2(arr);
//        findMaximumProfit();
    }
    
    public static void findMaximumProfit() {
        int[] a = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        int minValue = Integer.MAX_VALUE, minIndex = -1, maxValue = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < minValue) {
                minValue = a[i];
                minIndex = i;
            }
            if (a[i] >= maxValue) {
                maxValue = a[i];
                maxIndex = i;
            }
        }

        int minMaxIndex = minIndex, minMaxValue = minValue;
        for (int i = minIndex; i < a.length; i++) {
            if (a[i] > minMaxValue) {
                minMaxValue = a[i];
                minMaxIndex = i;
            }
        }

        int maxMinIndex = maxIndex, maxMinValue = maxValue;
        for (int i = maxIndex; i >= 0; i--) {
            if (a[i] < maxMinValue) {
                maxMinValue = a[i];
                maxMinIndex = i;
            }
        }

        System.out.println("From min to max: [" + minIndex + "][" + minMaxIndex + "], profit: " + (minMaxValue - minValue));
        System.out.println("From max to min: [" + maxIndex + "][" + maxMinIndex + "], profit: " + (maxValue - maxMinValue));
    }
    
    public static int[] findMaximumSubarrayWithSimpleWay(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int left = -1;
        int right = -1;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    left = i;
                    right = j;
                }
            }
        }

        return new int[]{left, right, maxSum};
    }
    
    
    public static int[] findMaximumSubarrayWithSimpleWay2(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int left = -1;
        int right = -1;
        int i,j;
        for (i = 0; i < arr.length; i++) {
            int sum = 0;
            for (j = i; j < arr.length; j++) {
                System.out.print("arr["+j+"] + ");
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    left = i;
                    right = j;
                }
            }
//            System.out.printf(" =%d  [%d.. %d]\n", sum, i, j);
            System.out.print(" = " + sum);
            System.out.print(" --> maxSum = " + maxSum);
            System.out.print(" ["+left+".."+right+"] \n");
        }

        return new int[]{left, right, maxSum};
    }
    
    
    public static int[] findMaximumSubarray(int[] a, int low, int high) {
        if (low == high) {
            return new int[]{low, high, a[low]};
        } else {
            int mid = (low+high)/2;
            int[] left = findMaximumSubarray(a, low, mid);       
            int[] right = findMaximumSubarray(a, mid+1, high);   
            int[] cross = findMaxCrossingSubarray(a, low, mid, high);
            
            if(left[2] >= right[2] && left[2] >= cross[2]) 
                return left;
            else if (right[2] >= left[2] && right[2] >= cross[2]) 
                return right;
            else 
                return cross;
        }
    }
    
    private static int[] findMaxCrossingSubarray(int[] a , int low, int mid, int high) {
        int sum = 0, maxLeftSum = Integer.MIN_VALUE, maxRightSum = Integer.MIN_VALUE;   
        int maxLeft = -1, maxRight = -1;            
        
        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (maxLeftSum < sum) {
                maxLeftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += a[j];
            if (maxRightSum < sum) {
                maxRightSum = sum;
                maxRight = j;
            }
        }

        return new int[]{ maxLeft, maxRight, (maxLeftSum + maxRightSum)}; 
    }
    
}

