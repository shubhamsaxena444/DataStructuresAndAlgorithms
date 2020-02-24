package leetcode.amazon.trees;

public class invertTree {
    public TreeNode invertTree(TreeNode A) {
        if(A==null )return A;

        TreeNode left = invertTree(A.left);
        TreeNode right = invertTree(A.right);
        A.left = right;
        A.right = left;
        return A;
    }
}
