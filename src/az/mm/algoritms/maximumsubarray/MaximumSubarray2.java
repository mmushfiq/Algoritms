package az.mm.algoritms.maximumsubarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MaximumSubarray2 {

    public static void main(String[] args) {
        int[] change = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        change = new int[]{12, -7, -3, -3, 12, -1, -8, -4, 6, -3, 4, 5, -7, 12, 13};
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] arr2 = {6, 4, -5, 3, -6, -5, -1, 8, 0, 9, -4, 10, 5, -3, -4}; 
        
        //-6, -3, 9, -1, -2, 8, -4, -4, -3, 2, -6, 1, -4, 12, -7
        // [2, -3, 8, -2, 3, -5, -4, -8, -5, 8, 12, 1, 2, 12, 4] hele ki en yaxsi
        // 12, -7, -3, -3, 12, -1, -8, -4, 6, -3, 4, 5, -7, 12, 13
        
//        findMaximumSubarrayWithSimpleWay2(arr);
        findMaximumProfit();
        
//        change = createUniqueIntArray(15, 10, -10);
//        findMaximumSubarrayWithKadane2(change);
    }
    
public static void findMaximumProfit() {
    int[] a = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
    int length = a.length;
    int minValue = Integer.MAX_VALUE, minIndex = 0, maxValue = Integer.MIN_VALUE, maxIndex = 0;
    for (int i = 0; i < length; i++) {
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
    for (int i = minIndex; i < length; i++) {
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
        int maxSum = Integer.MIN_VALUE, sum = 0;
        int left = 0, right = 0;
        for (int i = 0, length = arr.length; i < length; i++) {
            sum = 0;
            for (int j = i; j < length; j++) {
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
        int maxSum = Integer.MIN_VALUE, sum = 0;;
        int left = -1;
        int right = -1;
        int i,j;
        for (i = 0; i < arr.length; i++) {
            System.out.println("Addim " + i);
            sum = 0;
            for (j = i; j < arr.length; j++) {
                System.out.print("\tarr["+j+"] + ");
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
    
    
    public static int[] findMaximumSubarrayWithKadane(int arr[]) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        int left = 0, right = 0, next = 0;

        for (int i = 0, length = arr.length; i < length; i++) {
            sum += arr[i];

            if (maxSum < sum) {
                maxSum = sum;
                left = next;
                right = i;
            }
            if (sum < 0) {
                sum = 0;
                next = i + 1;
            }
        }
        return new int[]{left, right, maxSum};
    }

    public static int[] findMaximumSubarrayWithKadane2(int arr[]) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        int left = 0, right = 0, next = 0;
        int i = 0;

        for (int length = arr.length; i < length; i++) {
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
        System.out.println(i + "] maxSum: " + maxSum);
        System.out.println("\n[" + left + ".. " + right + "] maxSum: " + maxSum + " <-- result");
        return new int[]{left, right, maxSum};
    }
    
    
    public static int[] createUniqueIntArray(int length, int maxValue, int minValue){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<length; i++){
            int random1 = new Random().nextInt((maxValue - minValue) + 1) + minValue;
            int random2 = new Random().nextInt(5) + 1;
            int value = random1 + random2;
//            if(!list.contains(value)) 
                list.add(value);
        }
        int[] arr = list.stream().mapToInt(i->i).toArray();
        
        System.out.println(Arrays.toString(arr));
       
        return arr;
    }

    
}

