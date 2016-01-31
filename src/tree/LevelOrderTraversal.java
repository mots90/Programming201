package tree;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by moheet-dev on 1/31/2016.
 */
public class LevelOrderTraversal {

    Tree root;

    LevelOrderTraversal() {
        root= Tree.getSampleTree();
    }

    public void levelOrderTraversal(Tree root) {

        ArrayList<Tree> list = new ArrayList<Tree>();
        ArrayList<Tree> newList = new ArrayList<Tree>();

        list.add(root);

        while (!list.isEmpty()) {

            Tree node = list.remove(0);

            System.out.print(node.data + " ");
            if (node.right!=null) {
                newList.add(node.right);
            }
            if (node.left!=null) {
                newList.add(node.left);
            }

            if (list.isEmpty()) {
                list = newList;
                newList = new ArrayList<Tree>();
                System.out.println();
            }

        }
    }

    public ArrayList<Integer> nodesAtGivenLevel(Tree root, int level) {

        ArrayList<Tree> list = new ArrayList<Tree>();
        ArrayList<Tree> newList = new ArrayList<Tree>();
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> listOfLevelElements = new ArrayList<Integer>();

        list.add(root);

        while (!list.isEmpty()) {

            Tree node = list.remove(0);

            listOfLevelElements.add(node.data);

            if (node.right!=null) {
                newList.add(node.right);
            }
            if (node.left!=null) {
                newList.add(node.left);
            }

            if (list.isEmpty()) {
                list = newList;
                newList = new ArrayList<Tree>();
                listOfLists.add(listOfLevelElements);
                listOfLevelElements = new ArrayList<Integer>();
            }

        }

        return listOfLists.get(level);
    }

    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.levelOrderTraversal(levelOrderTraversal.root);

        System.out.println();System.out.println();
        System.out.println("level 0 : " +levelOrderTraversal.nodesAtGivenLevel(levelOrderTraversal.root,0));
        System.out.println("level 1 : " +levelOrderTraversal.nodesAtGivenLevel(levelOrderTraversal.root,1));
        System.out.println("level 2 : " +levelOrderTraversal.nodesAtGivenLevel(levelOrderTraversal.root,2));
        System.out.println("level 3 : " +levelOrderTraversal.nodesAtGivenLevel(levelOrderTraversal.root,3));


    }
}
