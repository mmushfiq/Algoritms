package az.mm.algoritms;

public class LonelyInteger {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2, 4, 3};
        
        /*
        //test uchun
        arr = new int[]{1, 1, 2};
        arr = new int[]{0, 0, 1, 2, 1};
        arr = new int[]{4, 5, 7, 6, 4, 7, 5, 8, 8};
        */
        
        System.out.println(getLonelyInteger2(arr));
    }

    public static int getLonelyInteger(int[] arr) {
        int unique = 0;
        for (int i : arr) 
            unique ^= i;
        
        return unique;
    }
    
    
    public static int getLonelyInteger2(int[] arr) {
        int unique = 0;
        for (int i : arr) {
            System.out.print(Integer.toBinaryString(i)+" - ");
            System.out.println(Integer.toString(i, 2));
            unique ^= i;
        }

        return unique;
    }
    

}
