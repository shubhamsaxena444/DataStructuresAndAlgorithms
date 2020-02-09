package leetcode.amazon.trees;

public class Diameter {
    int res = 1;
    public int diameterOfBinaryTree(TreeNode root) {

        height(root);
        return res-1;
    }

    int height(TreeNode root) {
        if(root ==null)return 0;
        // if(root.left == null && root.right ==null)return 1;
        int lh = height(root.left);
        int rh = height(root.right);
        res = Math.max(res,1+lh+rh);
        return 1+ Math.max(lh,rh);
    }
}
