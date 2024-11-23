package GFG.arrays;

import java.util.*;

/**
 * The ArrayIntersection class provides a method to find the intersection of two integer arrays.
 */
public class ArrayIntersection {

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> frequencyMap = createFrequencyMap(nums1);
        List<Integer> result = new ArrayList<>();

        for (int num : nums2) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                result.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Map<Integer, Integer> createFrequencyMap(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}