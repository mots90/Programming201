package tree;

import java.util.Stack;

/**
 * Created by moheet-dev on 1/31/2016.
 */
public class TreeTraversal {

    Tree root;
    TreeTraversal() {
        this.root = Tree.getSampleTree();
    }

    public void iterativeInorderTraversal(Tree node) {
        Stack<Tree> stack = new Stack<Tree>();

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                Tree nodeToBeVisited = stack.pop();
                System.out.print(nodeToBeVisited.data+" ");
                node = nodeToBeVisited.right;
            }
        }

    }

    public void iterativePreoderTraversal(Tree node) {
        Stack<Tree> stack = new Stack<Tree>();

        while (!stack.isEmpty() || node != null) {

            if (node != null) {
                System.out.print(node.data+" ");
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            }
            else {
                node = stack.pop();
            }


        }
    }

    public static void main(String[] args) {
        TreeTraversal traversal = new TreeTraversal();
        System.out.println("The original tree (printed using recursive inorder) is : ");
        Tree.printInOrderWithRecursion(traversal.root);
        System.out.println("Inorder Traversal : ");
        traversal.iterativeInorderTraversal(traversal.root);
        System.out.println("Preorder Traversal : ");
        traversal.iterativePreoderTraversal(traversal.root);

    }
}
