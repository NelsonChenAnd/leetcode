package leetcode.array;

/**
 * 给定一个数组，数组中每个元素代表从当前位置可以向后跳的最大距离。
 * 判断从第一个位置起，是否能跳转到最后一个位置。
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */

class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length<=1) {
            return true;
        }

        int nextMaxDist = 0;
        for(int i=0; i<nums.length; i++) {
            if(i+nums[i]>nextMaxDist) {
                nextMaxDist=i+nums[i];
            }

            if(nextMaxDist>=nums.length-1) {
                return true;
            }

            if(nums[i]==0 && nextMaxDist<=i) {
                return false;
            }

        }
        if(nextMaxDist>=nums.length-1) {
            return true;
        } else {
            return false;
        }
    }
}
