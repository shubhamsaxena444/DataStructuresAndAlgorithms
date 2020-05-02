package leetcode.googleAndFacebook.frequentlyasked;

import java.util.HashMap;
/*
* 523. Continuous Subarray Sum
Medium

1096

1535

Add to List

Share
Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.



Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.*/
public class ContSubarraySumTricky {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }
}

/*
swa

hash based
  23,2,4,6,7
  1 2 12

  1,0
  3,1

  curSum%k
  5,0, 1,


  hm 23,25,29,35,42

    sum -k == key

    store sum % k and check sum%k -k
  5,1,5


  k=6

  sum =25
  (sum - k)%k ==0 is present in hashmap, then it means we return true,

  sum - key = k*n
  sum- k*n =. key

  sum = key +k*n
  sum%k = key%k +0

  for(n =1 ;n<sum/k ;n++){
  //search for keys

  }

O(N*n) = totalSum/k
1...n

  hasmap[23,]
O(N*N)
k =6


1. keep expanding curWin till curWinSum <k
2. shrink my window


*/
