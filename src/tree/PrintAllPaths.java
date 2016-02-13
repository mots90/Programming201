package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * this program prints all the paths from root to leaves
 *
 * Created by moheet-dev on 2/2/2016.
 */
public class PrintAllPaths {

    Tree root = Tree.getSampleTree();

    public void printAllPaths(Tree root, List<Integer> list) {

        if (root == null) {
            return;
        }

        list.add(root.data);

        ArrayList<Integer> list1 = (ArrayList<Integer>)((ArrayList<Integer>)list).clone();
        ArrayList<Integer> list2 = (ArrayList<Integer>)((ArrayList<Integer>)list).clone();

        if (root.left == null && root.right == null) {
            printList(list);
        }

        printAllPaths(root.left, list1);
        printAllPaths(root.right, list2);


    }

    private void printList(List<Integer> list) {

        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        PrintAllPaths printer = new PrintAllPaths();
        printer.printAllPaths(printer.root, new ArrayList<Integer>());

    }



}
