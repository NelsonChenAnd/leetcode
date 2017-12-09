package leetcode.array;
/**
 * 给定一个数组，数组中的数值按照顺序平铺到bar中。如果下雨的话，计算可以装下多少水。
 * 时间复杂度（O(n)）
 * @Link https://leetcode.com/problems/trapping-rain-water/description/
 * 没有思路。。。
 * 双指针问题。需要一些奇技淫巧，不是传统的模板题。
 */
class TrappingRainWater {

    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax=0;
        int rightMax=0;
        int ans = 0;
        while(left<=right) {
            if(leftMax<=rightMax) {
                if(height[left]<leftMax) {
                    ans+=(leftMax-height[left]);
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if(height[right]<rightMax) {
                    ans+=(rightMax-height[right]);
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
