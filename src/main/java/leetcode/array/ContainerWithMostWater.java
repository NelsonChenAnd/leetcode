package leetcode.array;

/**
 *
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height.length<=1) {
            return 0;
        }
        int max = 0;

        int low = 0;
        int high = height.length-1;

        while(low<high) {
            max = Math.max(max, (high-low) * Math.min(height[low], height[high]));
            if(height[low]<height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return max;
    }
}
