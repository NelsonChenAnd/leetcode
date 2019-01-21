package leetcode.backpack;

/**
 * Author: SJ
 * Date: 2019/1/2
 *
 * Given a non-empty array containing only positive integers, find if the
 * array can be partitioned into two subsets such that the sum of elements
 * in both subsets is equal.
 *
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * 0/1 背包问题，每个物品可以选1次。
 *
 */
public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        if(nums.length==0) {
            return false;
        }
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
        }
        if(sum%2==1) {
            return false;
        }
        sum/=2;
        boolean[] dp = new boolean[sum+1];
        dp[0]=true;
        for(int i=0; i<nums.length; i++) {
            for(int j=sum; j>=nums[i]; j--) { // 特别要注意这里的循环顺序，从V 到Ci
                dp[j] = dp[j-nums[i]]||dp[j];
            }
//            System.out.println(i + "\t" + Arrays.toString(dp));
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        boolean ans = canPartition(new int[] {
                1, 1, 3, 5
        });
        System.out.println(ans);
    }
}
