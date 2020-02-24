package leetcode.amazon.trees;

public class inordersuccessor {

    public TreeNode getSuccessor(TreeNode a, int b) {
        TreeNode succ =null;
        if(a ==null)return succ;
        TreeNode cur = a;
        while(cur!=null){

            if(cur.val  == b ){
                //find leftmost element in the right subtree
                if(cur.right !=null){
                    succ = getLeftMostNode(cur.right);
                }
                return succ;
            }else  if(cur.val <b){
                cur = cur.right;
            }else{
                succ = cur;
                cur = cur.left;
            }
        }
        return succ;



    }

    TreeNode getLeftMostNode(TreeNode a){

        while(a.left!=null){
            a =a.left;
        }
        return a;
    }
}
