package az.mm.algoritms.sort;

public class MergeSort {
    private final int[] tempArr, arr;
    
    private MergeSort(int [] arr){
        this.arr = arr;
        tempArr = new int[arr.length];
    }

    public static void main(String[] args) {
        int[] testArray = {3, 5, 9, 1, 4, 6, 2, 8, 7};
        sort(testArray);
    }
    
    public static void sort(int arr[]) {
        MergeSort m = new MergeSort(arr);
        m.divide(0, arr.length-1);
    }

    private void divide(int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) return;
        int middle = (firstIndex + lastIndex) / 2;

        divide(firstIndex, middle);       // left
        divide(middle + 1, lastIndex);    // right
        conquer(firstIndex, middle, lastIndex);
    }
    
    private void conquer(int firstIndex, int middle, int lastIndex) {
        System.arraycopy(arr, firstIndex, tempArr, firstIndex, lastIndex - firstIndex + 1);
        
        int i = firstIndex;  // start index for the left array
        int j = middle + 1;  // start index for the right array
        int k = firstIndex;  // start index for the original array
        
        while(i <= middle && j <= lastIndex)
            if(tempArr[i] <= tempArr[j])  
                arr[k++] = tempArr[i++];
            else 
                arr[k++] = tempArr[j++];
        
        while(i <= middle)
            arr[k++] = tempArr[i++];
    }
    
}
