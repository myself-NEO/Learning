import dataStructuresAlgos.trees.TreeNode;

public class countNonLeaves {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int ans = countNonLeafNodes(root);
        System.out.println(ans);

    }

    public static int countNonLeafNodes(TreeNode root) {
        int[] ans = {0};
        countnl(root, ans);
        return ans[0];
    }

    public static void countnl(TreeNode root, int[] ans) {
        if(root.left == null && root.right==null) return;
        if(root.left != null || root.right != null) ans[0]+= 1;
        countnl(root.left, ans);
        countnl(root.right, ans);
    }
}
