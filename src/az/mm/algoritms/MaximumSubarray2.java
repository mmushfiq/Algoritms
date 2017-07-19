package az.mm.algoritms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MaximumSubarray2 {

    public static void main(String[] args) {
        findMaximumProfit();
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
}

