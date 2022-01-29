package Tree;

public class Main {
    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>("A");
        root.left = new TreeNode<>("B");
        root.right = new TreeNode<>("E");
        root.left.left = new TreeNode<>("C");
        root.left.right = new TreeNode<>("D");
        root.right.right = new TreeNode<>("F");

        qxtest(root);
        System.out.println();
        System.out.println("=============");
        zxtest(root);
        System.out.println();
        System.out.println("=============");
        hxtest(root);
    }

    private static void qxtest(TreeNode<?> root) {
        if (root == null) return;
        System.out.print(root.e+" ");
        qxtest(root.left);
        qxtest(root.right);
    }
    private static void zxtest(TreeNode<?> root) {
        if (root == null) return;
        zxtest(root.left);
        System.out.print(root.e+" ");
        zxtest(root.right);
    }
    private static void hxtest(TreeNode<?> root) {
        if (root == null) return;
        hxtest(root.left);
        hxtest(root.right);
        System.out.print(root.e+" ");
    }
}
