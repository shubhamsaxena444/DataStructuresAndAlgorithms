package GFG.arrays.DP;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        //kadane's algorithm
        int maxSoFar = 0;
        int maxTotal = 0 ;
        for(int i = 0; i < nums.length ;i++){
            maxSoFar += nums[i];
            if(maxSoFar < 0){
                maxSoFar=0;
            }
            if(maxSoFar > maxTotal){
                maxTotal =maxSoFar;
            }
        }
        return maxTotal;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
