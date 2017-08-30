package az.mm.algoritms.treetraversals;

import java.util.Stack;

public class BSTraversalWithStack {
    
    private static int[] bst = {0, 25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90};
    /*
        InOrder:    4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90
        Pre-order:  25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90
        Post-order: 4, 12, 10, 18, 24, 22, 15, 31, 44, 35, 66, 90, 70, 50, 25
    */

    public static void main(String[] args) {
        
        BSTraversalWithStack bst = new BSTraversalWithStack();
        int root = 1; // 0 deyil, 1 olacaq chunki root deyerimiz 1-ci indeksden bashlayir
  
        System.out.print("\nin-order with Stack:\t");
        bst.inOrderWithStack(root);

        System.out.print("\npre-order with Stack:\t");
        bst.preOrderWithStack(root);
        
        System.out.print("\npost-order with Stack:\t");
        bst.postOrderWithStack(root);
    }
    
    public void inOrderWithStack(int i) {
        Stack<Integer> stack = new Stack<Integer>();
        while (!stack.isEmpty() || i < bst.length) 
            if (i < bst.length) {
                stack.push(i);
                i = left(i);
            } else {
                i = stack.pop();
                System.out.print(bst[i] + " ");
                i = right(i);
            }
    }
    
    public void preOrderWithStack(int i) {
        Stack<Integer> stack = new Stack<Integer>();
        while (!stack.isEmpty() || i < bst.length) 
            if (i < bst.length) {
                System.out.print(bst[i] + " ");
                stack.push(i);
                i = left(i);
            } else {
                i = stack.pop();
                i = right(i);
            }
    }
    
    public void postOrderWithStack(int i) {
        Stack<Integer> stack = new Stack<Integer>();
        /*
        *
        */
    }
    
    private int left(int i)  { return 2*i; }
    private int right(int i) { return 2*i+1; }
    
    public void inOrderWalkWithoutRecursion(int i) {
        Stack<Integer> stack = new Stack<Integer>();
        while (!stack.isEmpty() || i < bst.length) 
            if (i < bst.length) {
                stack.push(i);
                i = 2*i; //left
            } else {
                i = stack.pop();
                System.out.print(bst[i] + " ");
                i = 2*i+1; //right
            }
    }
    
}
