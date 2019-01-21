package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * Author: SJ
 * Date: 2018/12/2
 *
 */
public class Sum3 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i-1]==nums[i]) {
                continue;
            }
            int target = -nums[i];
            int low = i+1, high = nums.length-1;

            while(low<high) {
                if(low==i) {
                    low++;
                    continue;
                }
                if(high==i) {
                    high--;
                    continue;
                }
                if(nums[low]+nums[high]==target) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[low]);
                    tmp.add(nums[high]);
                    ans.add(tmp);

                    low++;
                    while(low<high && nums[low]==nums[low-1]) {//控制重复
                        low++;
                    }
                    high--;
                    while(low<high && nums[high]==nums[high+1]) {//控制重复
                        high--;
                    }
                } else if(nums[low]+nums[high]<target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return ans;
    }
}
