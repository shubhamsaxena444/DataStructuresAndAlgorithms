package leetcode.uber.treesAndGraphs;

import java.util.*;

/*Approach #1 Recursive Solution[Accepted]
We start by initializing a resres array with the dimensions being heightheightx2^{height}-12
height
 −1. Here, heightheight refers to the number of levels in the given tree. In order to fill this resres array with the required elements, initially, we fill the complete array with "" . After this we make use of a recursive function fill(res, root, i, l, r) which fills the resres array such that the current element has to be filled in i^{th}i
th
  row, and the column being the middle of the indices ll and rr, where ll and rr refer to the left and the right boundaries of the columns in which the current element can be filled.

In every recursive call, we do as follows:

If we've reached the end of the tree, i.e. if root==null, return.

Determine the column in which the current element(rootroot) needs to be filled, which is the middle of ll and rr, given by say, jj. The row number is same as ii. Put the current element at res[i][j]res[i][j].

Make the recursive call for the left child of the rootroot using fill(res, root.left, i + 1, l, (l + r) / 2).

Make the recursive call for the right child of the rootroot using fill(res, root.right, i + 1, (l + r + 1) / 2, r).

Note, that in the last two recursive calls, we update the row number(level of the tree). This ensures that the child nodes fit into the correct row. We also update the column boundaries appropriately based on the ll and rr values.

Further, to determine the heightheight also, we make use of recursive funtion getHeight(root), which returns the height of the tree starting from the rootroot node. We traverse into all the branches possible in the tree recursively and find the depth of the longest branch.

At the end, we convert the resres array into the required list format, before returning the results.


Complexity Analysis

Time complexity : O(h*2^h)O(h∗2
h
 ). We need to fill the resres array of size hhx2^h - 12
h
 −1. Here, hh refers to the height of the given tree.

Space complexity : O(h*2^h)O(h∗2
h
 ). resres array of size hhx2^h - 12
h
 −1 is used.*/
public class PrintTree {
    public PrintTree() {
    }

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for(String[] arr:res)
            Arrays.fill(arr,"");
        List<List<String>> ans = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for(String[] arr:res)
            ans.add(Arrays.asList(arr));
        return ans;
    }
    public void fill(String[][] res, TreeNode root, int i, int l, int r) {
        if (root == null)
            return;
        res[i][(l + r) / 2] = "" + root.val;
        fill(res, root.left, i + 1, l, (l + r) / 2);
        fill(res, root.right, i + 1, (l + r + 1) / 2, r);
    }
    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
