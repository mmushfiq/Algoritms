package az.mm.algoritms.maximumsubarray;

import static java.lang.Integer.max;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MaximumSubarray2_DaC2 {

    public static void main(String[] args) {
        int[] change = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        change = new int[]{12, -7, -3, -3, 12, -1, -8, -4, 6, -3, 4, 5, -7, 12, 13};
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] arr2 = {6, 4, -5, 3, -6, -5, -1, 8, 0, 9, -4, 10, 5, -3, -4};

        //-6, -3, 9, -1, -2, 8, -4, -4, -3, 2, -6, 1, -4, 12, -7
        // [2, -3, 8, -2, 3, -5, -4, -8, -5, 8, 12, 1, 2, 12, 4] hele ki en yaxsi
        // 12, -7, -3, -3, 12, -1, -8, -4, 6, -3, 4, 5, -7, 12, 13
        
         change = new int[]{16, -10, -22, 14, -9, -1, 27, -16, 13, -4, -18, -7, 13, -3, 8, 4, -20, 9, 15, -22};
//        arr=change;
        System.out.println(Arrays.toString(findMaximumSubarray(arr, 0, arr.length-1)));
        System.out.println("count: " + count);
//        System.out.println(findMaximumSubarray2(arr, 0, arr.length-1));
//        System.out.println(findMaximumSubarray3(arr, 0, arr.length-1));
        
//        System.out.println(findMaximumSubarray22(arr, 0, arr.length-1));
    }

    public static int[] findMaximumSubarray(int[] a, int low, int high) {
//        System.out.println("low: " + low + ", high: "+high);
        if (low == high) return new int[]{low, high, a[low]};

        int mid = (low + high) / 2;
        int[] left = findMaximumSubarray(a, low, mid);
        int[] right = findMaximumSubarray(a, mid + 1, high);
        int[] cross = findMaxCrossingSubarray(a, low, mid, high);

//        if (left[2] >= right[2] && left[2] >= cross[2]) {
//            return left;
//        } else if (right[2] >= left[2] && right[2] >= cross[2]) {
//            return right;
//        } else {
//            return cross;
//        }
        
        if (compare("leftSum >= rightSum", left, right) && compare("leftSum >= crossSum", left, cross)) {
            return left;
        } else if (compare("rightSum >= leftSum", right, left) && compare("rightSum >= crossSum", right, cross)) {
            return right;
        } else {
            return cross;
        }
        
    }
    
    static boolean compare(String s, int[] a, int[] b){
        System.out.println(s + " \t "+a[2]+" >= " + b[2] + " \t a["+a[0]+"]["+a[1]+"] b["+b[0]+"]["+b[1]+"]");
        return a[2] >= b[2];
    }
    
    static int count = 0;
    private static int[] findMaxCrossingSubarray(int[] a, int low, int mid, int high) {
        count++;
        System.out.print("low:" + low);
        System.out.print(" mid:" + mid);
        System.out.print(" high:" + high+"\n");
        int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int maxLeft = -1, maxRight = -1;

        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (leftSum < sum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += a[j];
            if (rightSum < sum) {
                rightSum = sum;
                maxRight = j;
            }
        }

        return new int[]{maxLeft, maxRight, (leftSum + rightSum)};
    }

    public static int[] createUniqueIntArray(int length, int maxValue, int minValue) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int random1 = new Random().nextInt((maxValue - minValue) + 1) + minValue;
            int random2 = new Random().nextInt(5) + 1;
            int value = random1 + random2;
//            if(!list.contains(value)) 
            list.add(value);
        }
        int[] arr = list.stream().mapToInt(i -> i).toArray();

        System.out.println(Arrays.toString(arr));

        return arr;
    }


    //divide and conquer 2
    static int findMaximumSubarray2(int[] arr, int low, int high) {
        if (low == high)  return arr[low];
        
        int middle = (low + high) / 2;
        
        int left = findMaximumSubarray2(arr, low, middle);
        int right = findMaximumSubarray2(arr, middle + 1, high);
        
        int leftSum = arr[middle];
        int rightSum = arr[middle + 1];
        int sum = 0;
        
        for (int i = middle; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        
        sum = 0;
        for (int i = middle + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return max(max(left, right), leftSum + rightSum);
    }
    
    //divide and conquer 22
    static int findMaximumSubarray22(int[] arr, int low, int high) {
        if (low == high)  return arr[low];
        
        int middle = (low + high) / 2;
        
        int leftArr = findMaximumSubarray22(arr, low, middle);
        int rightArr = findMaximumSubarray22(arr, middle + 1, high);
        
        int left = 0, leftSum = arr[middle];
        int right = 0, rightSum = arr[middle + 1];
        int sum = 0, maxSum;
        
        for (int i = middle; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                left = i;
            }
        }
        
        
        sum = 0;
        for (int i = middle + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                right = i;
            }
        }
        
        if (leftSum >= rightSum && leftSum >= (leftSum + rightSum)) {
            System.out.println("1");
            maxSum = leftSum;
        } else if (rightSum >= leftSum && rightSum > (leftSum + rightSum)) {
            System.out.println("2");
             maxSum = rightSum;
        } else {
            System.out.println("3");
             maxSum = leftSum + rightSum;
        }
        System.out.println("maxSum="+maxSum);
        return max(max(left, right), leftSum + rightSum);
    }


// divide and conquer 3
    static int findMaximumSubarray3(int[] arr, int low, int high) {
        if (low == high) return arr[low];
        
        int mid = (low + high) / 2;

        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;	// reset sum to 0
        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

	// Recursively find the maximum subarray sum for left subarray 
        // and right subarray and tale maximum
        int maxLeftRight = max(findMaximumSubarray3(arr, low, mid),
                findMaximumSubarray3(arr, mid + 1, high));

        // return maximum of the three
        return max(maxLeftRight, leftSum + rightSum);
    }
    
    

}
