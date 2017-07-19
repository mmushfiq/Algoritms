package az.mm.algoritms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MaximumSubarray {
    static long start, duration;

    public static void main(String[] args) {
        int[] priceOfDays = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        int[] change = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        
//        start();
//        priceOfDays = createUniqueIntArray(30, 100, 70);
//        change = createDifferencesArray(valuesOfDays);
//        end();
//        
        priceOfDays = new int[]{88, 104, 94, 72, 86, 77, 76, 103, 87, 100, 96, 78, 71, 84, 81, 89, 93, 73, 82, 97, 75};
        change = new int[]{16, -10, -22, 14, -9, -1, 27, -16, 13, -4, -18, -7, 13, -3, 8, 4, -20, 9, 15, -22};
        

        System.out.println("\n----findMaximumProfit----"); 
        start();
        findMaximumProfit(priceOfDays);  // bura gunler gonderilmelidi
        end();

        System.out.println("\n----findMaximumSubarray recursive----");
        start();
        printArr(findMaximumSubarray(change, 0, change.length-1));
        end();
        
        System.out.println("\n----findMaxCrossingSubarray ----");
        start();
        printArr(findMaxCrossingSubarray(change, 0, change.length/2, change.length-1));
        end();
        
        System.out.println("\n----maxSubArraySum Kadane's Algorithm geeksforgeeks ----");
        start();
        printArr(maxSubArraySum(change));
        end();
        
        System.out.println("\n----maxSumSimpleWay codereview.stackexchange.com ----");
        start();
        printArr(maxSumSimpleWay(change));
        end();
        
        
        System.out.println("\nValues fo days --> " + Arrays.toString(priceOfDays));
        printArr(priceOfDays);
        
        System.out.println("\nDifferences --> " + Arrays.toString(change));
        printArr(change);
        
//          System.out.println("\nList size --> " + differences.length);

        
    }
    
    /*
    public static int[] findMaximumSubarrayRecursive(int[] arr){
        
    }
    */

    //bunu custor usulla ozum yazmisham..
    public static void findMaximumProfit(int[] a) {
        //indi chatdi ki mene bu massiv ferqleri yox verilen numunedeki gunleri muqayise etmelidi, ona gore digeri ile cavab ust uste dushmur
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
    
    
    // 1st way - simple way using nested loops O(n^2) - https://codereview.stackexchange.com/questions/52249/find-the-subarray-with-the-max-sum 
    static int[] maxSumSimpleWay(int[] array) {
        int maxsum = Integer.MIN_VALUE;
        int maxl = -1;
        int maxr = -1;
        for (int left = 0; left < array.length; left++) {
            int sum = 0;
            for (int right = left; right < array.length; right++) {
                sum += array[right];
                if (sum > maxsum) {
                    maxsum = sum;
                    maxl = left;
                    maxr = right;
                }
            }
        }

        return new int[]{maxl, maxr, maxsum};
    }

    
    // 2nd way - recursive using divide and conquer method O(nlogn) - 
    public static int[] findMaximumSubarray(int[] a, int low, int high) {
        if (low == high) {
            return new int[]{low, high, a[low]};
        } else {
            int mid = (low+high)/2;
            int[] left = findMaximumSubarray(a, low, mid);      // left
//            System.out.println("left[] --> "+Arrays.toString(left));
            int[] right = findMaximumSubarray(a, mid+1, high);   // right
//            System.out.println("right[] --> "+Arrays.toString(right));
            int[] cross = findMaxCrossingSubarray(a, low, mid, high);
            
            if(left[2] >= right[2] && left[2] >= cross[2]) return left;
            else if (right[2] >= left[2] && right[2] >= cross[2]) return right;
            else return cross;
        }
    }
    
    public static int[] findMaxCrossingSubarray(int[] a , int low, int mid, int high) {
        int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;   // sum-dan bashqa digerlerine ozum 0 menimsetmishem, sonra min value eledim.. 
        int maxLeft = 0/*mid*/, maxRight = 0/*mid+1*/;            // ...onu arashdirib deqiqleshdirmek lazimdi..
        
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

//        System.out.println("[" + maxLeft + "]-[" + maxRight + "] " + (leftSum + rightSum));
        
        return new int[]{ maxLeft, maxRight, (leftSum + rightSum)}; 
    }
    
    // 3rd way - using Kadane's Algorithm, the best way according to complexity O(n) - http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
    static int[] maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        int left=0, right=0, temp=0;

        for (int i = 0; i < size; i++) {
            max_ending_here += a[i];
            
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                left=temp;
                right = i;
            }
            if (max_ending_here < 0){
                max_ending_here = 0;
                temp=i+1;
            } 
        }
        return new int[]{left, right, max_so_far};
    }

    
    
    //----------------- additions ----------------------------------------------
    public static int[] createUniqueIntArray(int length, int maxValue, int minValue){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<length; i++){
            int random1 = new Random().nextInt((maxValue - minValue) + 1) + minValue;
            int random2 = new Random().nextInt(9) + 1;
            int value = random1 + random2;
            if(!list.contains(value)) 
                list.add(value);
        }
        int[] arr = list.stream().mapToInt(i->i).toArray();
       
        return arr;
    }
    
    
    public static int[] createDifferencesArray(int arr[]){
        int differencesArr[] = new int[arr.length-1];
        for(int i=0, length = arr.length-1; i<length; i++){
            differencesArr[i] = arr[i+1]-arr[i];
        }
        System.out.println("Massivler yaradildi!");
        return differencesArr;
    }
    
    
    private static void printArr(int[] arr){
        for(int i=0, length=arr.length-1; i <= length; i++ )
            System.out.println("index["+i+"] = " + arr[i]);
    }
    
    private static void start(){
        start = System.currentTimeMillis();
    }
    
    private static void end(){
        duration = System.currentTimeMillis()-start;
        System.out.println("Duration: " + duration + "ms");
    }
    
    
    
    //http://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/ - rekursiv uchun ferqli kodlama
    int maxSubArraySum(int arr[], int l, int h) {
        // Base Case: Only one element
        if (l == h) {
            return arr[l];
        }

        // Find middle point
        int m = (l + h) / 2;

//    Return maximum of following three possible cases
//      a) Maximum subarray sum in left half
//      b) Maximum subarray sum in right half
//      c) Maximum subarray sum such that the subarray crosses the midpoint 
        return max(maxSubArraySum(arr, l, m),
                maxSubArraySum(arr, m + 1, h),
                maxCrossingSum(arr, l, m, h));
    }

    int maxCrossingSum(int arr[], int l, int m, int h) {
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum) {
                left_sum = sum;
            }
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum) {
                right_sum = sum;
            }
        }

        // Return sum of elements on left and right of mid
        return left_sum + right_sum;
    }
   
    
    int max(int a, int b) { return (a > b)? a : b; }
    int max(int a, int b, int c) { return max(max(a, b), c); }
 
}


/*
    Bu blogda lazim olacaq mene..
        valuesOfDays = new int[]{88, 104, 94, 72, 86, 77, 76, 103, 87, 100, 96, 78, 71, 84, 81, 89, 93, 73, 82, 97, 75};
        differences = new int[]{16, -10, -22, 14, -9, -1, 27, -16, 13, -4, -18, -7, 13, -3, 8, 4, -20, 9, 15, -22};
*/

