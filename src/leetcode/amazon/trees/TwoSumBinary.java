package leetcode.amazon.trees;
import java.util.*;

public class TwoSumBinary {
     int index = 0;
    ArrayList<Integer> inorder = new ArrayList<>();

    public int t2Sum(TreeNode A, int B) {

        inorder(A);
        for(int i =0,j=inorder.size()-1;i<j;){
            if(inorder.get(i) == B-inorder.get(j) ){
                return 1;
            }else if(inorder.get(i) < B-inorder.get(j)){
                i++;
            }else{
                j--;
            }
        }
        return 0;
    }
    void inorder(TreeNode A){
        if(A==null)return;
        inorder(A.left);
        inorder.add(index,A.val);
        index++;
        inorder(A.right);
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(10);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        r.left = left;
        r.right = right;
        TwoSumBinary ob = new TwoSumBinary();
        System.out.println(ob.t2Sum(r,19));
    }
}
