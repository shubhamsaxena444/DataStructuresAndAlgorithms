package leetcode.amazonAndMicrosoft.trees;

import java.util.*;

public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root ==null)return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> l = new ArrayList<>();
        while(!q.isEmpty()){

            TreeNode temp = q.poll();
            if(temp == null){
                if(!q.isEmpty()){
                    q.add(null);
                }
                res.add(l);
                l  = new ArrayList<>();
            }else{
                l.add(temp.val);
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }

            }
        }
        return res;
    }
}
