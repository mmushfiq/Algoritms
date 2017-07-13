package az.mm.algoritms.sort;

import java.util.Arrays;

public class MergeSort_COPY {
    int[] tempArr;
    int[] arr = {3, 5, 9, 1, 4, 6, 2, 8, 7};

    public static void main(String[] args) {
//        int[] arr = {3, 5, 9, 1, 4, 6, 2, 8, 7};
        MergeSort_COPY m = new MergeSort_COPY();
//        m.mergeSort(arr);
        m.mergeSort();
        
    }
    
    private void mergeSort(/*int[] arr*/) {
        divide(0, arr.length-1);
        System.out.print("\t" + Arrays.toString(arr));
    }

    private void divide(int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) return;
        int mid = (firstIndex + lastIndex) / 2;
        
        divide(firstIndex, mid);     // left
        divide(mid+1, lastIndex);    // right
        conquer(firstIndex, mid, lastIndex);
    }
    
    private void conquer(int firstIndex, int middle, int lastIndex) {
//        tempArr = new int[j-i+1];
        tempArr = new int[arr.length];
        System.arraycopy(arr, firstIndex, tempArr, firstIndex, lastIndex - firstIndex + 1);
        System.out.print(Arrays.toString(tempArr));
        System.out.print("\t" + Arrays.toString(arr));
        System.out.printf("\t i=%d k=%d j=%d%n", firstIndex, middle, lastIndex);
        
        
        int i = firstIndex;
        int j = middle + 1;
        int k = firstIndex;
        
        while(i <= middle && j <= lastIndex){
            if(tempArr[i] < tempArr[j]){
                arr[k] = tempArr[i++];
            } else {
                arr[k] = tempArr[j++];
            }
            k++;
        }
        
//        while(j <= lastIndex){
//            arr[k++] = tempArr[j++];
//        }
        while(i <= middle){
            arr[k++] = tempArr[i++];
        }
        
        
        
//        int[] L = new int[m-f+1];
//        int[] R = new int[l-m];
//        for(int i=0; i<L.length; i++){
//            L[i] = arr[f++];
//        }
//        for(int i=0; i<R.length; i++){
//            R[i] = arr[m++ + 1];
//        }
//        
//        for(int k=0, n=0; k < L.length && n < R.length; ){
//            if(L[k] < R[n]){
//                arr[f++] = L[k++];
//            } else {
//                arr[f++] = L[n++];
//            }
//        }
//        
//        System.out.println("L" + Arrays.toString(L));
//        System.out.println("R" + Arrays.toString(R));
        

//        while (f <= m && m < l) {
//            if (tempArr[f] < tempArr[l]) {
////                    arr[i] = tempArr[f];
//                System.out.print(tempArr[f]+" ");
//                f++;
//            } else {
////                    arr[i] = tempArr[l];
//                System.out.print(tempArr[l]+" ");
//                l--;
//            }
//        }
//        System.out.println("");

        
    }
    
}
