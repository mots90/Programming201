import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by moheet-dev on 10/18/2014.
 */
public class TreeOperations {

    public static void printVertically(Tree root){

        Stack<Tree> stack;
        ArrayList<Tree> queue = new ArrayList<Tree>();
        System.out.println("Tree nodes in vertical order are");
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

    public static void printLevelOrder(Tree root){
        ArrayList<Tree> list = new ArrayList<Tree>();
        list.add(root);
        System.out.println("Tree nodes in level order are");
        while(list.size()!=0){
            System.out.println();
            ArrayList<Tree> newList = new ArrayList<Tree>();
            Tree node;
            while(list.size()!=0){
                node = list.remove(0);
                if(node.left!=null)
                    newList.add(node.left);
                if(node.right!=null)
                    newList.add(node.right);
                System.out.print(node.data+" ");
            }
            list = newList;
        }
    }

    public static void printStack(Stack<Tree> stack){
        while(!stack.isEmpty()){
            System.out.println(stack.pop().data);
        }
    }
    public static void main(String[] args){

        Tree tree = Tree.getSampleTree();
        //Tree.printInOrderWithRecursion(tree);
        printVertically(tree);
        //printLevelOrder(tree);
    }
}
