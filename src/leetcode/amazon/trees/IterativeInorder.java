package leetcode.amazon.trees;

import java.util.*;

public class IterativeInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur =root;
        // s.add(root);
        while(cur !=null || !s.isEmpty()){
            //keep pushing in stack till there is a left child

            while(cur !=null){
                s.push(cur);
                cur=cur.left;
            }
            cur =s.pop();
            res.add(cur.val);
            //if(cur!=null)
            cur=cur.right;
        }
        return res;
    }
}
