package tree;

/**
 * Created by moheet-dev on 2/2/2016.
 */
public class HeightAndSize {

    Tree root = Tree.getSampleTree();

    public int getHeight(Tree root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int righttHeight = getHeight(root.right);

        return (leftHeight > righttHeight) ? leftHeight + 1 : righttHeight + 1;
    }

    public int getSize(Tree root) {
        if (root == null) {
            return 0;
        }

        int leftSize = getSize(root.left);
        int rightSize = getSize(root.right);

        return 1+ leftSize + rightSize;
    }

    public static void main(String[] args) {

        HeightAndSize finder = new HeightAndSize();
        System.out.println("Height of the tree is " + finder.getHeight(finder.root));
        System.out.println("Size of the tree is " + finder.getSize(finder.root));
    }
}
