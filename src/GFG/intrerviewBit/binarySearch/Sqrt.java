package GFG.intrerviewBit.binarySearch;

public class Sqrt {
    public int sqrt(int n) {
        //let k is the square root of n
        //one way is to run a loop from 1 to k*k<=n

      /*  //root n solution
        int i=1;
        for(;i*i<=n;i++){

        }
        if(i*i == n)
            return i;
        return i-1;
        */
        if(n<=1)return n;
        int start = 1 ,end=n;

        int ans=1;

        while(start<=end){

            int mid = start+(end-start)/2;
           // long mid2 = mid*mid;
            if(mid <= n/mid){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
}
