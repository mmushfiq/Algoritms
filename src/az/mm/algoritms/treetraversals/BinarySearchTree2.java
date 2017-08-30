package az.mm.algoritms.treetraversals;

public class BinarySearchTree2 {
    
//    private static int[] bst = {0, 25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90};
    /*
        InOrder:    4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90
        Pre-order:  25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90
        Post-order: 4, 12, 10, 18, 24, 22, 15, 31, 44, 35, 66, 90, 70, 50, 25
    */
    
//    private static int[] bst = {0, 1, 2, 3, 4, 5, 6, 7, 8, 0, 0, 11, 0, 12, 0, 0, 9, 10};
//    private static int[] bst = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};  //izah ucun bu boyuk olacaq
    
//        private static int[] bst = {0, 1, 2, 3, 4, 5, 6, 7};
        private static int[] bst = {0, 25, 15, 50, 10, 22, 35, 70};
    
    public static void main(String[] args) {
        
        BinarySearchTree2 bst = new BinarySearchTree2();
        int root = 1; // 0 deyil, 1 olacaq chunki root deyerimiz 1-ci indeksden bashlayir
        
//        System.out.print("level-order:\t");
//        bst.levelOrderWalk(root);
        
//        System.out.print("\nin-order:\t\n");
//        bst.inOrderWalk(root);
        
        System.out.print("\npre-order:\t\n");
        bst.preOrderWalk(root);
        
//        System.out.print("\npost-order:\t\n");
//        bst.postOrderWalk(root);
    }
    
    public void levelOrderWalk(int i){
        if(i >= bst.length) return;
        
        print(i);
        levelOrderWalk(++i);
    }
    
    public void inOrderWalk(int i){
        if(i >= bst.length) return;
        inOrderWalk(left(i));
        print(i);
        inOrderWalk(right(i));
    }
    
    public void preOrderWalk(int i){
        if(i >= bst.length) return;
        
        print(i);
        preOrderWalk(left(i));
        preOrderWalk(right(i));
    }
    
    public void postOrderWalk(int i){
        if(i >= bst.length) return;
        
        postOrderWalk(left(i));
        postOrderWalk(right(i));
        print(i);
    }
    
    private void print(int i){
//        if(bst[i] != 0)
//            System.out.println("print: "+bst[i] + " ");
            System.out.printf("%d is popped from stack and print \n", bst[i]);
    }
    
    private int left(int i)  {
        if(2*i < bst.length)
            System.out.printf("left-child(%d) is pushed to stack \n", bst[2*i]);
        else 
            System.out.printf("left-child of '%d' not exists! \n", bst[i]);
        
        return 2*i; 
    }
    private int right(int i) { 
        if(2*i+1 < bst.length)
            System.out.printf("right-child(%d) is pushed to stack \n", bst[2*i+1]);
         else 
            System.out.printf("right-child of '%d' not exists! \n", bst[i]);
        
        return 2*i+1; 
    }
    
}
