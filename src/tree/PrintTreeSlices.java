package tree;

/**
 * Created by moheet-dev on 1/31/2016.
 */
public class PrintTreeSlices {
}



/*
    public static void printVertically(Tree root){

        Stack<Tree> stack;
        ArrayList<Tree> queue = new ArrayList<Tree>();
        System.out.println("tree.Tree nodes in vertical order are");
        queue.add(root);
        while(!queue.isEmpty()){
            Tree node = queue.remove(queue.size()-1);
            stack = new Stack<Tree>();
            stack.push(node);
            while(node!=null){
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(node.left!=null)
                    stack.push(node.left);
                node=node.left;
            }
            printStack(stack);
        }
    }
 */
