package leetcode.amazon.trees;

public class hasPath {
    public int hasPathSum(TreeNode A, int B) {
        if(A==null)return 0;
        if(A.val==B && A.left==null && A.right==null)return 1;
        return hasPathSum(A.left,B-A.val)|hasPathSum(A.right,B-A.val);
    }
}
