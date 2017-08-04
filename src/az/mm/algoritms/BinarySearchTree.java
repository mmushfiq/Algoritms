package az.mm.algoritms;

public class BinarySearchTree {
    
    private static int[] bst = {0, 25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90};
    /*
        InOrder:    4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90
        Pre-order:  25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90
        Post-order: 4, 12, 10, 18, 24, 22, 15, 31, 44, 35, 66, 90, 70, 50, 25
    */
    
    public static void main(String[] args) {
        
        BinarySearchTree bst = new BinarySearchTree();
        int root = 1; // 0 deyil, 1 olacaq chunki root deyerimiz 1-ci indeksden bashlayir
        
        System.out.print("inorder:\t");
        bst.inOrderTraverse(root);
        
        System.out.print("\npre-order:\t");
        bst.preOrderTraverse(root);
        
        System.out.print("\npost-order:\t");
        bst.postOrderTraverse(root);
    }
    
    public void inOrderTraverse(int i){
        if(i >= bst.length) return;
        
        inOrderTraverse(left(i));
        print(i);
        inOrderTraverse(right(i));
    }
    
    public void preOrderTraverse(int i){
        if(i >= bst.length) return;
        
        print(i);
        preOrderTraverse(left(i));
        preOrderTraverse(right(i));
    }
    
    public void postOrderTraverse(int i){
        if(i >= bst.length) return;
        
        postOrderTraverse(left(i));
        postOrderTraverse(right(i));
        print(i);
    }
    
    private void print(int i){
        System.out.print(bst[i] + " ");
    }
    
    private int left(int i)  { return 2*i; }
    private int right(int i) { return 2*i+1; }
    
}
