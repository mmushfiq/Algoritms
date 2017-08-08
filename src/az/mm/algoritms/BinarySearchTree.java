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
        
        System.out.print("level-order:\t");
        bst.levelOrderWalk(root);
        
        System.out.print("\nin-order:\t");
        bst.inOrderWalk(root);
        
        System.out.print("\npre-order:\t");
        bst.preOrderWalk(root);
        
        System.out.print("\npost-order:\t");
        bst.postOrderWalk(root);
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
        System.out.print(bst[i] + " ");
    }
    
    private int left(int i)  { return 2*i; }
    private int right(int i) { return 2*i+1; }
    
}
