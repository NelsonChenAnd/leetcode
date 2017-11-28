package leetcode.array;

/**
 * 功能描述：Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 *
 *
 * 给定一个升序旋转的数组和一个目标搜索值，在数组中搜索该目标值。
 * 如果存在，返回该目标值的下标；如果不存在，返回-1。
 * @Link https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * @Author SJ
 * @Date 2017-11-28
 */
public class SearchInRotatedSortedArray {
    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = (low + high)/2;
            if(nums[mid]==target) {
                return mid;
            } else if(nums[low]<=nums[mid]) {
                if(target<nums[mid] && target>=nums[low]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if(target>nums[mid] && target<=nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray instance = new SearchInRotatedSortedArray();
        int nums[] = new int[]{1,2};
        System.out.println(instance.search(nums, 1));
    }
}
