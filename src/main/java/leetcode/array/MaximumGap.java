package leetcode.array;

/**
 * 功能描述：
 *
 * @Author SJ
 * @Date 2018-6-4
 */
public class MaximumGap {

    public static void main(String[] args) {
        int num[] = new int[] {
                1,10000000
        };
        System.out.println(maximumGap(num));
    }

    public static int maximumGap(int[] nums) {
        if(nums.length<=1) {
            return 0;
        }
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            minNum = Math.min(minNum, nums[i]);
            maxNum = Math.max(maxNum, nums[i]);
        }

        int min[] = new int[nums.length-1];
        int max[] = new int[nums.length-1];

        for(int i=0; i<min.length; i++) {
            min[i]=Integer.MAX_VALUE;
            max[i]=Integer.MIN_VALUE;
        }

        int gap = (int) Math.ceil(1.0*(maxNum-minNum)/(nums.length-1));

        System.out.println(maxNum+"\t" + minNum + "\t" + Math.ceil((maxNum-minNum)/(nums.length-1)));
        for(int num: nums) {
            int idx = (num-minNum)/gap;
            System.out.println(idx + " num "  + num + "\t" + minNum + "\t" +gap);
            min[idx] = Math.min(min[idx], num);
            max[idx] = Math.max(max[idx], num);
        }

        int ans = Integer.MIN_VALUE;
        int prev = -1;
        for(int i=0; i<min.length; i++) {
            if(i==0) {
                prev = max[i];
            } else {
                ans = Math.max(ans, min[i]-prev);
                prev = max[i];
            }
        }
        return ans;
    }
}
