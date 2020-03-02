package leetcode.amazonAndMicrosoft.trees;

import java.util.ArrayList;
//return all paths whose sum == B
public class AllPAthSum {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {

        sumPath( new ArrayList<Integer>(), A, B);
        return result;
    }
    public void sumPath( ArrayList<Integer> list, TreeNode A, int B) {
        if(A == null)
            return;
        // sum = sum + A.val;
        B = B- A.val;
        list.add(A.val);
        //base case
        if(A.left == null && A.right == null && 0 == B)
            result.add(new ArrayList<Integer>(list)); //here it requires a creation of new list

        sumPath( list, A.left, B);
        sumPath( list, A.right, B);
        //backtracking the same list
        B = B + list.remove(list.size()-1);
    }
}
