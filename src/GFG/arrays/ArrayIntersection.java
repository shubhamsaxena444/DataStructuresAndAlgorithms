package GFG.arrays;

import java.util.*;

public class ArrayIntersection {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0 || nums2.length == 0){
            return new int[]{};
        }
        List<Integer> r = new ArrayList<>();
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i =0 ;i<nums1.length;i++)    {
            hm.put(nums1[i],hm.get(nums1[i])==null?1:hm.get(nums1[i])+1);

        }
        for(int i =0;i<nums2.length;i++){
            //find in map, if found and frequency > 0, add in r and dec frequency.
            if(hm.containsKey(nums2[i]) && hm.get(nums2[i])>0){
                r.add(nums2[i]);
                hm.put(nums2[i],hm.get(nums2[i])-1);
            }
        }
        return r.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{4,9,5},new int[]{9,4,9,8,4})));
    }
}
