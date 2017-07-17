package az.mm.algoritms;

import java.util.Arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] days = {};
        int[] differences = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
//        findMaximumSubarray(differences);
//        findMaxCrossingSubarray(differences);
        
        int aa[] = findMaximumSubarray(differences, 0, differences.length-1);
        System.out.println(Arrays.toString(aa));
    }

    //bunu custor usulla ozum yazmisham..
    static void findMaximumSubarray(int[] a) {
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

        System.out.println("1st min to max: [" + minIndex + "][" + minMaxIndex + "], profit: " + (minMaxValue - minValue));
        System.out.println("1st max to min: [" + maxIndex + "][" + maxMinIndex + "], profit: " + (maxValue - maxMinValue));
    }
    
    

    static int[] findMaxCrossingSubarray(int[] a , int low, int mid, int high) {
//        low = 0;
//        high = a.length;
//        mid = high / 2;
        int sum = 0, leftSum = 0, maxLeft = 0, rightSum = 0, maxRight = 0;

        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (leftSum < sum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;
        for (int j = mid + 1; j < high; j++) {
            sum += a[j];
            if (rightSum < sum) {
                rightSum = sum;
                maxRight = j;
            }
        }

//        System.out.println("[" + maxLeft + "]-[" + maxRight + "] " + (leftSum + rightSum));
        
        return new int[]{ maxLeft, maxRight, (leftSum + rightSum)}; 
    }

    //rekursiv
    static int[] findMaximumSubarray(int[] a, int low, int high) {
        if (low == high) {
            return new int[]{low, high, a[low]};
        } else {
            int mid = (low+high)/2;
            int[] left = findMaximumSubarray(a, low, mid);      // left
            int[] right = findMaximumSubarray(a, mid+1, high);   // right
            int[] cross = findMaxCrossingSubarray(a, low, mid, high);
            
            if(left[2] >= right[2] && left[2] >= cross[2]) return left;
            else if (right[2] >= left[2] && right[2] >= cross[2]) return right;
            else return cross;
        }
    }

}


