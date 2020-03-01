package leetcode.amazonAndMicrosoft.arraysAndString;
/**/
public class TrappingRainWater {
    /*Algorithm

Find maximum height of bar from the left end upto an index i in the array \text{left\_max}left_max.
Find maximum height of bar from the right end upto an index i in the array \text{right\_max}right_max.
Iterate over the \text{height}height array and update ans:
Add \min(\text{max\_left}[i],\text{max\_right}[i]) - \text{height}[i]min(max_left[i],max_right[i])−height[i] to ansans*/


    /*Approach 4: Using 2 pointers
Intuition

As in Approach 2, instead of computing the left and right parts seperately, we may think of some way to do it in one iteration. From the figure in dynamic programming approach, notice that as long as \text{right\_max}[i]>\text{left\_max}[i]right_max[i]>left_max[i] (from element 0 to 6), the water trapped depends upon the left_max, and similar is the case when \text{left\_max}[i]>\text{right\_max}[i]left_max[i]>right_max[i] (from element 8 to 11). So, we can say that if there is a larger bar at one end (say right), we are assured that the water trapped would be dependant on height of bar in current direction (from left to right). As soon as we find the bar at other end (right) is smaller, we start iterating in opposite direction (from right to left). We must maintain \text{left\_max}left_max and \text{right\_max}right_max during the iteration, but now we can do it in one iteration using 2 pointers, switching between the two.

Algorithm

Initialize \text{left}left pointer to 0 and \text{right}right pointer to size-1
While \text{left}< \text{right}left<right, do:
If \text{height[left]}height[left] is smaller than \text{height[right]}height[right]
If \text{height[left]} \geq \text{left\_max}height[left]≥left_max, update \text{left\_max}left_max
Else add \text{left\_max}-\text{height[left]}left_max−height[left] to \text{ans}ans
Add 1 to \text{left}left.
Else
If \text{height[right]} \geq \text{right\_max}height[right]≥right_max, update \text{right\_max}right_max
Else add \text{right\_max}-\text{height[right]}right_max−height[right] to \text{ans}ans
Subtract 1 from \text{right}right.*/

    /*int trap(vector<int>& height)
{
    int left = 0, right = height.size() - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
            ++left;
        }
        else {
            height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
            --right;
        }
    }
    return ans;
}*/
}
