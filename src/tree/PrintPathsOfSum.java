package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * this program prints all the paths from root to leaves
 *
 * Created by moheet-dev on 2/2/2016.
 */
public class PrintPathsOfSum {

    Tree root = Tree.getSampleTree();

    public void printAllPaths(Tree root, List<Integer> list, int sum) {

        if (root == null) {
            return;
        }

        list.add(root.data);

        ArrayList<Integer> list1 = (ArrayList<Integer>)((ArrayList<Integer>)list).clone();
        ArrayList<Integer> list2 = (ArrayList<Integer>)((ArrayList<Integer>)list).clone();

        int temp = sum;
        for (int i = list.size()-1; i>=0; i--) {
            temp -= list.get(i);
            if (temp == 0){
                printList(list, i);
            }
        }

        printAllPaths(root.left, list1, sum);
        printAllPaths(root.right, list2, sum);
    }

    private void printList(List<Integer> list, int start) {

        for (int i = start; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        PrintPathsOfSum printer = new PrintPathsOfSum();
        printer.printAllPaths(printer.root, new ArrayList<Integer>(), 12);

    }



}
