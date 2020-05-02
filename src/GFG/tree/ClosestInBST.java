package GFG.tree;

public class ClosestInBST {
    class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
    }
    public static void main(String[] args) {

    }
    int closest =-1;
    double diff = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        if(root ==null){
            return -1;
        }
        int v = root.val;
        double newDiff= Math.abs(target-v);
        if(newDiff<diff){
            closest= v;
            diff = newDiff;
        }
        if(target < v){
            return closestValue(root.left, target);
        }else if(target>v){
            return closestValue(root.right, target);
        }
        return closest;
    }

}
