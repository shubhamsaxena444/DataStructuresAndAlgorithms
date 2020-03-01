package leetcode.amazonAndMicrosoft.trees;

public class LCA
{
    TreeNode ans =null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        doesLowestCommonAncestorExist(root,p,q);
        return ans;
    }

    public boolean doesLowestCommonAncestorExist(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null)return false;
        //if any of the p or is root, then return root

        //find if root is in left or right
        int left = doesLowestCommonAncestorExist(root.left,p,q)  ? 1: 0;
        int right =doesLowestCommonAncestorExist(root.right,p,q) ? 1: 0;
        int mid =0;
        if(root ==p || root ==q ){
            mid =1;
        }
        if(left + right +mid >=2){
            ans = root;
        }
        return left + right +mid > 0 ? true:false;
    }
}
