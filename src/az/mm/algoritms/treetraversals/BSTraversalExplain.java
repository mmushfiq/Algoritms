package az.mm.algoritms.treetraversals;

public class BSTraversalExplain {

    private static int[] bst = {0, 25, 15, 50, 10, 22, 35, 70};
    
    public static void main(String[] args) {
        
        BSTraversalExplain bst = new BSTraversalExplain();
        int root = 1; // 0 deyil, 1 olacaq chunki root deyerimiz 1-ci indeksden bashlayir
        bst.inOrderWalk(root);
    }
    
    public void inOrderWalk(int i){
        if(i >= bst.length) return;
        inOrderWalk(left(i));
        print(i);
        inOrderWalk(right(i));
    }
    
    private void print(int i){
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
