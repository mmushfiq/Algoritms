package az.mm.algoritms.sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int arr[] = {2, 5, 3, 0, 2, 3, 0, 3};
        int k = 9; // massivin maksimum elementinin deyeri
        int[] sortedArray = sort(arr, k);
        System.out.println(Arrays.toString(sortedArray));
    }
    
    public static int[] sort(int[] a, int k){
        int[] c = new int[k+1];
        int aLength = a.length;
        for(int i = 0; i < aLength; i++)
            c[a[i]]++;
        
        for(int j = 1; j <= k; j++)
            c[j] = c[j] + c[j-1];
        
        int[] sortedArray = new int[aLength];
        for(int n = aLength-1; n>=0; n--){
            sortedArray[c[a[n]]-1] = a[n];  //indeksler 0-dan basladigi ucun -1 etmeliyik
            c[a[n]]--;
        }
        
        return sortedArray;
    }
    
}

