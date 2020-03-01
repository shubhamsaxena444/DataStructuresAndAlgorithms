package leetcode.amazonAndMicrosoft.trees;

public class pathsum {
    public int sumNumbers(TreeNode A) {

        return helper(A,0);
    }
    int helper(TreeNode r, int val){

        if(r ==null)return 0;

        //update
        val = (val*10 + r.val)%1003;
        if(r.left ==null && r.right ==null)return val;

        return (helper(r.left,val) + helper(r.right,val))%1003;
    }
}
