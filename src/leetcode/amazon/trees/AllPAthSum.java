package leetcode.amazon.trees;

import java.util.ArrayList;

public class AllPAthSum {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {

        sumPath( new ArrayList<Integer>(), A, B, 0);
        return result;
    }
    public void sumPath( ArrayList<Integer> list, TreeNode A, int B, int sum) {
        if(A == null)
            return;
        // sum = sum + A.val;
        B = B- A.val;
        list.add(A.val);
        if(A.left == null && A.right == null && 0 == B)
            result.add(new ArrayList<Integer>(list));
        sumPath( list, A.left, B, sum);
        sumPath( list, A.right, B, sum);
        B = B + list.remove(list.size()-1);
    }
}
