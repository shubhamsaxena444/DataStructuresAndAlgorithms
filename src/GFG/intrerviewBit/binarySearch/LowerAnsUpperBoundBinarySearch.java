package GFG.intrerviewBit;

public class LowerAnsUpperBoundBinarySearch {
    public int[] searchRange(final int[] A, int B) {
        int[] res = new int[]{-1,-1};
        if(A.length == 0)return res;
        helper(A,B,true,res);
        helper(A,B,false,res);
        return res;
    }

    void helper(int[] a,int k,boolean left,int[] res){
        int start =0,end =a.length-1;
        // int[] res = new int[2];
        int Lans=-1,Rans=-1;
        while(start<=end){
            int mid = start+ (end-start)/2;
            if(a[mid] == k && left){
                Lans =mid; //update with possible answer
                end =mid-1;
            }else if(a[mid] == k){
                Rans =mid; //update with possible answer
                start = mid+1;
            }else if(k<a[mid]){
                end =mid-1;
            }else{
                start =mid+1;
            }
        }
        if(left){
            res[0] =Lans;
        }else{
            res[1] =Rans;
        }
    }
}
