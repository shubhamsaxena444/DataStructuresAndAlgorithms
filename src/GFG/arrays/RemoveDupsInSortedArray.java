package GFG.arrays;

public class RemoveDupsInSortedArray {

    public static void main(String[] args) {
        int[] nums= new int[]{1,1,1,2,2};
        int l = removeDuplicatesOptimised(nums);
        System.out.println(l);
        for(int i =0;i<l;i++){
            System.out.print(nums[i]);
        }

    }

    private static int removeDuplicatesOptimised(int[] nums) {
        int index= 1 ;  // since 0th element will never be replaced and always be unique.
        for(int i =0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[index++] = nums[i+1];
            }
        }

        return index;

    }

    public static int removeDuplicates(int[] nums) {
        //o(n^2)
        int dup=0;
        if(nums.length == 0){
            return 0;
        }

        //run a pass to count the number of dups
        for (int p =0;p<nums.length-1;p++){
            if(nums[p]==nums[p+1]){
                dup++;
            }
        }

        //everytime you encounter a duplicate, inc the duplicate count by 1;
        int i= 0 , j =0;
        while(i<=j && j<nums.length-1){

            if( nums[i] == nums[j+1]){
                j++;
            }else{
                // left shift from j by j-i
                leftShift(nums, i, j);
                i++;
                j=i;
            }
        }

        return nums.length - dup;
    }

    private static void leftShift(int[] nums, int i, int j) {
        for(int k =j;k<nums.length;k++){
            nums[k-(j-i)] =nums[k];

        }
    }
}
