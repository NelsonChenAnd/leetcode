package leetcode.dp;

/**
 * Author: SJ
 * Date: 2019/1/23
 *
 *
 * Given n balloons, indexed from 0 to n-1.
 *
 * Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons. If the you burst balloon i you
 * will get nums[left] * nums[i] * nums[right] coins. Here left and right
 * are adjacent indices of i. After the burst, the left and right then
 * becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 *
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you
 * can not burst them.
 *
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 *
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * 思想：动态规划。
 * 按照间隔3->nums.length+2的顺序展开，逐步从小间隔计算大间隔。
 * dp[i][j]表示从i到j的最大BurstBalloons结果值。
 */
public class BurstBalloons_312 {
    public int maxCoins(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        int data[] = new int[nums.length+2];
        data[0] = data[data.length-1]=1;
        for(int i=1; i<data.length-1; i ++) {
            data[i] = nums[i-1];
        }

        int[][] dp = new int[data.length][data.length];

        for(int k=2; k<data.length; k++) {
            for(int left = 0; left<data.length-k; left++) {
                int right = left+k;
                for(int i=left+1; i<right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            data[left] * data[i] * data[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][data.length-1];
    }
}
