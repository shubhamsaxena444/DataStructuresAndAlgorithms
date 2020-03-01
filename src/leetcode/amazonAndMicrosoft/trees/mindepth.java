package leetcode.amazonAndMicrosoft.trees;

import java.util.LinkedList;
import java.util.Queue;

public class mindepth {
    class Node{
        int depth;
        TreeNode tn;
        Node(  TreeNode tn, int depth){
            this.tn=tn;
            this.depth=depth;
        }
    }
    public int minDepth(TreeNode A) {
        if(A==null)return 0;
        if(A.left ==null && A.right ==null)return 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A,1));
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.tn.left==null && temp.tn.right ==null){
                return temp.depth;
            }
            if(temp.tn.left!=null){
                q.add(new Node(temp.tn.left,temp.depth+1));
            }
            if(temp.tn.right!=null){
                q.add(new Node(temp.tn.right,temp.depth+1));
            }

        }
        return -1;
    }
}
