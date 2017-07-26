package az.mm.algoritms.maximumsubarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MaximumSubarray {
    
    private static long start, duration;

public static void main(String[] args) {
    
int[] priceOfDays, change; 

/*
// "Səhm A" numunesi uchun 
priceOfDays = new int[]{100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
change = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};

// "Səhm B" numunesi uchun
priceOfDays = new int[]{88, 104, 94, 72, 86, 77, 76, 103, 87, 100, 96, 78, 71, 84, 81, 89, 93, 73, 82, 97, 75};
change = new int[]{16, -10, -22, 14, -9, -1, 27, -16, 13, -4, -18, -7, 13, -3, 8, 4, -20, 9, 15, -22};

// Ashagidaki metodlarla yuxaridaki numunelere benzer numuneler yaradib testler ede bilersiniz
priceOfDays = createUniqueIntArray(30, 100, 70);
change = createDifferencesArray(priceOfDays);
*/

// boyuk hecmli test uchun unique olma shertini qaldiracam, chunki contains metodu xeyli vaxt alacaq
priceOfDays = createUniqueIntArray(1_000, 5000, -5000);

System.out.println("1st way");
start();
print(findMaximumSubarrayWithSimpleWay(priceOfDays));
end();

System.out.println("2nd way");
start();
print(findMaximumSubarray(priceOfDays, 0, priceOfDays.length-1));
end();

System.out.println("3rd way");
start();
print(findMaximumSubarrayWithKadane(priceOfDays));
end();
}


// 1st way - simple way using nested loops, complexity O(n^2) 
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


// 2nd way - divide and conquer, complexity O(nlogn)
public static int[] findMaximumSubarray(int[] a, int low, int high) {
    if (low == high) return new int[]{low, high, a[low]};
    
    int mid = (low+high)/2;
    int[] left = findMaximumSubarray(a, low, mid);       
    int[] right = findMaximumSubarray(a, mid+1, high);   
    int[] cross = findMaxCrossingSubarray(a, low, mid, high);

    if(left[2] >= right[2] && left[2] >= cross[2]) 
        return left;
    else if (right[2] >= cross[2])  // right[2] >= left[2] shertini chixardim, chunki onsuz da odenir
        return right;
    else 
        return cross;
}


private static int[] findMaxCrossingSubarray(int[] a , int low, int mid, int high) {
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

    return new int[]{ maxLeft, maxRight, (leftSum + rightSum)}; 
}


// 3rd way - Kadane's Algorithm, complexity O(n)
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




private static int[] createUniqueIntArray(int length, int maxValue, int minValue){
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<length; i++){
        int random1 = new Random().nextInt((maxValue - minValue) + 1) + minValue;
        int random2 = new Random().nextInt(9) + 1;
        int value = random1 + random2;
//            if(!list.contains(value)) 
            list.add(value);
    }
    int[] arr = list.stream().mapToInt(i->i).toArray();
    System.out.println("Array length = " + arr.length + "\n");

    return arr;
}

private static int[] createDifferencesArray(int arr[]){
    int differencesArr[] = new int[arr.length-1];
    for(int i=0, length = arr.length-1; i<length; i++){
        differencesArr[i] = arr[i+1]-arr[i];
    }
    return differencesArr;
}

private static void print(int[] arr){
    System.out.println(Arrays.toString(arr));
}

private static void start(){
    start = System.currentTimeMillis();
}

private static void end(){
    duration = System.currentTimeMillis()-start;
    System.out.println("Duration: " + duration + "ms\n");
}
    
}

