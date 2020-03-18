package leetcode.googleAndFacebook.arrays;
/*Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.





The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.*/
public class ContainerWithMostWater
{
    public int maxArea(int[] height) {
        int n = height.length;
        if(n==0)return 0;
        int maxArea=0,start =0,end= n-1;
        while(start<end){
            int curArea = Math.min(height[start],height[end]) *(end-start);
            maxArea = Math.max(maxArea,curArea);
            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxArea;
    }
}
