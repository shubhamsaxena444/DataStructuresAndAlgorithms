package leetcode.google.arrays;

import java.util.List;

import java.util.ArrayList;

public class MissingRanges {
    List<String> res;
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        res = new ArrayList<String>();

        long ll = lower, uu = upper;

        // special case
        if (nums.length == 0) {
            format(ll-1, uu+1);
            return res;
        }

        // lower -> first element
        format(ll-1, nums[0]);

        // intervals within elements
        for (int i=1; i<nums.length; i++) {
            format(nums[i-1], nums[i]);
        }

        // last element -> upper
        format(nums[nums.length-1], uu+1);

        return res;
    }

    public void format(long start, long end) {
        long diff = end -  start;
        String str = null;
        if (diff <= 1) str = null;
        else if (diff == 2) str = (start+1) + "";
        else str = (start+1) + "->" + (end-1);

        if (str != null) res.add(str);
    }
}
