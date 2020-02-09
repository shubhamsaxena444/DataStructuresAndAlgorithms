package leetcode.amazon.trees;

public class ValidateBST {

    //for edge cases
    public boolean isValidBST(TreeNode root) {
        return check(root,null,null);
    }
    //we need to take null to handle edge cases.
    private boolean check(TreeNode r,Integer min,Integer max){
        if (r == null )return true;

        if(min !=null && r.val <= min)return false;

        if(max !=null && r.val >= max)return false;

        if(check(r.left,min,r.val) && check(r.right,r.val,max)){
            return true;
        }else{
            return false;
        }
    }
}
