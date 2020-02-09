package leetcode.amazon.trees;
/*Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42*/
public class MaxPathSum {
    int res = Integer.MIN_VALUE ;
    public int maxPathSum(TreeNode root) {
        //left a helper function return max sum from root to leaf.
        if(root ==null)return 0;

        maxSumTillLeaf(root);
        return res;
    }

    int maxSumTillLeaf(TreeNode root){
        if(root ==null)return 0;
        // if(root.left==null &&  root.right ==null)return root.val;//this condition causes problem as we are not able to compare with root.val
        //since we done need to to go till leaf
        int ls = Math.max(maxSumTillLeaf(root.left),0);
        int rs = Math.max(maxSumTillLeaf(root.right),0);
        res = Math.max(res, ls +rs +root.val);
        return root.val + Math.max( ls,rs);

    }
}
