package tree;

/**
 * Basic tree operations
 * Created by moheet-dev on 10/18/2014.
 */
public class Tree {
    Integer data = null;
    Tree left = null, right=null;

    /**
     *
     * @param data
     */
    Tree(int data){
        this.data = data;
    }

    /**
     *
     * @param data
     * @param left
     * @param right
     */
    Tree(int data, Tree left, Tree right){
        this(data);
        this.left = left;
        this.right=right;
    }

    public Integer getData() {
        return data;
    }

    public Tree getLeft() {
        return left;
    }

    public Tree getRight() {
        return right;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    /**
     *
     * @param root
     */
    public static void printInOrderWithRecursion(Tree root){
        if(root!=null){
            printInOrderWithRecursion(root.left);
            System.out.print(root.data+" ");
            printInOrderWithRecursion(root.right);
        }
    }

    public static Tree getSampleTree(){
        Tree root;
        Tree node5 = new Tree(5);
        Tree node3 = new Tree(3);
        Tree node2 = new Tree(2);
        Tree node1 = new Tree(1);
        Tree node4 = new Tree(4);
        Tree node7 = new Tree(7);
        Tree node6 = new Tree(6);
        Tree node8 = new Tree(8);
        root=node5;
        node5.left = node3;
        node5.right = node7;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;
        node7.left = node6;
        node7.right = node8;
        return root;
    }
}
