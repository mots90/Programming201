package careercup;

import tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by moheet-dev on 2/27/2016.
 * Given the root of a binary tree containing integers, print the columns of the tree in order with the nodes in each column printed top-to-bottom.


         Input:
                  6
                 / \
                3   4
               / \   \
              5   1   0
             / \     /
            9   2   8
                 \
                  7

         Output:
         9 5 3 2 6 1 7 4 8 0

         Input:
                   1
                 /   \
                2     3
               / \   / \
              4   5 6   7

         When two nodes share the same position (e.g. 5 and 6), they may be printed in either order:

         Output:
         4 2 1 5 6 3 7
         or:
         4 2 1 6 5 3 7
 *
 */
public class ColumnWiseTreePrinting {

    /*
        Idea is to associated column numbers with each of the nodes. start the recursion with
        root at the 0th column, recurse left node current_col-1 and right with current_col+1

        store this mapping in a hashmap col -> list of nodes in it
     */

    private Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    private int lowestCol = 0;

    public void generateColumnWiseMappings(Tree tree, int column) {
        if (tree == null) {
            return;
        }

        lowestCol = Math.min(lowestCol, column);

        List<Integer> list;
        if (map.containsKey(column)) {
            list = map.get(column);
            list.add(tree.getData());
        }
        else {
            list = new ArrayList<Integer>();
            list.add(tree.getData());
            map.put(column, list);
        }

        if (tree.getLeft() != null) {
            generateColumnWiseMappings(tree.getLeft(),column-1);
        }
        if (tree.getRight() != null) {
            generateColumnWiseMappings(tree.getRight(),column+1);
        }
    }

    private void printTree() {

        int i = lowestCol;
        while (map.size() != 0) {
            List<Integer> list = map.remove(i);
            if (list != null) {
                System.out.print(list);
            }
            i++;
        }
    }


    public static void main(String[] args) {
        ColumnWiseTreePrinting printer = new ColumnWiseTreePrinting();
        Tree tree = Tree.getSampleTree();
        printer.generateColumnWiseMappings(tree, 0);
        printer.printTree();
    }
}
