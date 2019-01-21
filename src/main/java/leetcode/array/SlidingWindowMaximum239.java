package leetcode.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * Author: SJ
 * Date: 2019/1/21
 *
 * HARD
 *  O（n）时间复杂度
 *  Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 */
public class SlidingWindowMaximum239 {

    public static void main(String[] args) {
        int[] nums = new int[] {
                1, 3, -1, -3, 5, 3, 6, 7
        };
        int[] ans = maxSlidingWindow2(nums, 3);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0||k<=0) {
            return nums;
        }
        int[] ans = new int[nums.length-k+1];
        // 双向队列
        Deque<Integer> queue = new ArrayDeque<>();

        int ri=0;
        for(int i=0; i<nums.length; i++) {
            if(!queue.isEmpty() && queue.peekFirst()<i-k+1) {
                queue.removeFirst();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]) {//注意这是while
                queue.removeLast();
            }
            queue.addLast(i);

//            System.out.println(queue);
            if(i>=k-1) {
                ans[ri++] = nums[queue.peekFirst()];
            }
        }
        return ans;
    }

    public static int[] maxSlidingWindow2(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.removeFirst();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.removeLast();
            }
            // q contains index... r contains content
            q.addLast(i);
            System.out.println(q);
            if (i >= k - 1) {
                r[ri++] = a[q.peekFirst()];
            }
        }
        return r;
    }
}
