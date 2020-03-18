package leetcode.googleAndFacebook.arrays;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        //if partition returns index i , it means i...n-1 are the greatest numbers
        //e.g, 0,1,2,3 ... i=2 , n-i = 2 , means 2nd largest element is nums[i]
        return findKthLargest(nums,nums.length,  k,0,nums.length-1);
    }
    public int findKthLargest(int[] nums,int n, int k,int s,int e) {
        if(s>e){
            return -1;
        }
        //if partition returns index i , it means i...n-1 are the greatest numbers
        //e.g, 0,1,2,3 ... i=2 , n-i = 2 , means 2nd largest element is nums[i]
        int index = partition(nums,s,e);
        if(n-index == k){
            return nums[index];
        }else if(n-index<k){
            //it must be in the left
            return findKthLargest(nums,n,k,s,index-1);
        }else{
            return findKthLargest(nums,n,k,index+1,e);
        }
    }
    int partition(int[] nums,int l,int h){
        int pivot =h;
        int i = l-1;
        for(int j =l;j<h;j++){
            if(nums[j]<nums[pivot]){
                i++;
                swap(nums,i,j);
            }

        }
        //replace pivot with i +1;
        swap(nums,i+1,pivot);
        return i+1;
    }
    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] =nums[j];
        nums[j] =temp;
    }

    public static void main(String[] args) {
        KthLargestElement obj = new KthLargestElement();
        System.out.println(obj.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
