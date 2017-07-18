package az.mm.algoritms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] valuesOfDays = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        int[] differences = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        
        valuesOfDays = createIntArrayFromList(30, 100, 70);
        differences = createDifferencesArray(valuesOfDays);
        
        valuesOfDays = new int[]{105, 91, 87, 109, 82, 89, 76, 101, 97, 107, 93, 71, 83, 92, 79, 78, 86, 85, 103};
        differences = new int[]{-14, -4, 22, -27, 7, -13, 25, -4, 10, -14, -22, 12, 9, -13, -1, 8, -1, 18};
        

        System.out.println("\n----findMaximumSubarray----");
        findMaximumSubarray(valuesOfDays);  // bura gunler gonderilmelidi

        System.out.println("\n----findMaximumSubarray recursive----");
        printArr(findMaximumSubarray(differences, 0, differences.length-1));
        
        System.out.println("\n----findMaxCrossingSubarray length-1 ----");
        printArr(findMaxCrossingSubarray(differences, 0, differences.length/2, differences.length-1));
        
        System.out.println("\n----maxSubArraySum geeksforgeeks ----");
        System.out.println(maxSubArraySum(differences));
        
        System.out.println("\n----maxSubArraySum2 geeksforgeeks ----");
        printArr(maxSubArraySum2(differences));
        
        System.out.println("\n----maxSubarraySumUsingNaiveMethod sunfoundry ----");
        printArr(maxSubarraySumUsingNaiveMethod(differences));
        
        
        System.out.println("\nValues fo days --> " + Arrays.toString(valuesOfDays));
        printArr(valuesOfDays);
        
        System.out.println("\nDifferences --> " + Arrays.toString(differences));
        printArr(differences);
        
    }
    
    /*
    public static int[] findMaximumSubarrayRecursive(int[] arr){
        
    }
    */

    //bunu custor usulla ozum yazmisham..
    public static void findMaximumSubarray(int[] a) {
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

        System.out.println("1st min to max: [" + minIndex + "][" + minMaxIndex + "], profit: " + (minMaxValue - minValue));
        System.out.println("1st max to min: [" + maxIndex + "][" + maxMinIndex + "], profit: " + (maxValue - maxMinValue));
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

    //rekursiv
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
    
    
    
    //----------------- elaveler ---------------------------------------------------------
    
    public static int[] createIntArrayFromList(int length, int maxValue, int minValue){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<length; i++){
            int random = new Random().nextInt((maxValue - minValue) + 1) + minValue;
            int random2 = new Random().nextInt(9) + 1;
            int value = random + random2;
            if(!list.contains(value)) list.add(value);
        }
        int[] arr = list.stream().mapToInt(i->i).toArray();
       
        return arr;
    }
    
    
    public static int[] createDifferencesArray(int arr[]){
        int differencesArr[] = new int[arr.length-1];
        for(int i=0, length = arr.length-1; i<length; i++){
            differencesArr[i] = arr[i+1]-arr[i];
        }
       
        return differencesArr;
    }
    
    
    private static void printArr(int[] arr){
        for(int i=0, length=arr.length-1; i <= length; i++ )
            System.out.println("index["+i+"] = " + arr[i]);
    }
    
    
    
    // http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/  - Kadane's Algorithm
    static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }
    
    
    static int[] maxSubArraySum2(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        int left=0, right=0, temp=0;

        for (int i = 0; i < size; i++) {
            max_ending_here += a[i];
            
            if (max_so_far < max_ending_here) {
//                if(max_so_far == Integer.MIN_VALUE) left = i;
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
    
    
    
    // http://www.sanfoundry.com/cpp-program-find-maximum-subarray-sum-on2-timenaive-method/ - O(n^2) - ich-iche for ile
    static int[] maxSubarraySumUsingNaiveMethod(int[] a){
        int sum=0, maxSum = -1, leftIndex=0, rightIndex=0;
        
        // Loop for the length of the sub-array.
        for (int i = 1; i < a.length+1; i++) {

            // Loop for the maximizing the sum of the element of the sub array of length 'i'.
            for (int j = 0; j < a.length; j++) {
                
                // First pick the first sub array of 'i' length.
                if (j < i) {
                    sum += a[j];
                } 
                // Add the next element and subtract the first element from the sub-array.
                else {
                    sum = sum + a[j] - a[j - i];
                }

                // Compare the sum with the global maximum of each length.
                if (maxSum < sum) {
                    // Assign the initial and the final indexes to the imax and the fmax variables and update the max, if condition satisfies.
                    leftIndex = j - i + 1;
                    rightIndex = j;
                    maxSum = sum;
                }
            }
        }
        
        return new int[]{leftIndex, rightIndex, maxSum};
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


