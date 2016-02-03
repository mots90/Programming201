package tree;

/**
 * Created by moheet-dev on 2/3/2016.
 */
public class Mirror {

    Tree root = Tree.getSampleTree();

    public Tree mirrorTheTree(Tree root) {

        if (root != null) {

            mirrorTheTree(root.left);
            mirrorTheTree(root.right);

            Tree temp = root.left;
            root.left = root.right;
            root.right= temp;
        }
        return root;
    }

    public static void main(String[] args) {
        Mirror mirror = new Mirror();

        System.out.println("before mirroring : ");
        Tree.printInOrderWithRecursion(mirror.root);
        mirror.root = mirror.mirrorTheTree(mirror.root);
        System.out.println("after mirroring : ");
        Tree.printInOrderWithRecursion(mirror.root);
    }
}
