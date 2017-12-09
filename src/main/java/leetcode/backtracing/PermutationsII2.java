package leetcode.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 数组中有重复的数字造成的影响：
 * 1） 相同数字交换，导致结果相同。
 * 2） 一个一步交换和一个多步交换效果一样，导致结果相同。
 *
 * 方案：
 * 可以用HashSet来完成去重的操作。
 * 2也可以使用visited 数组记录访问过的，访问过的数就不再递归。尼玛。。答案都看不懂。爆粗口。。。。
 */

class PermutationsII2 {

    public static void main(String[] args) {
        PermutationsII2 p = new PermutationsII2();
        int nums[] = new int[] {1,1,2,2};
        System.out.println(p.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        Arrays.sort(nums);
        boolean visited[] = new boolean[nums.length];
        permute2(nums, list, ans, visited);
        return ans;
    }

    private void permute2(int[] num, List<Integer> list, List<List<Integer>> ans, boolean[] visited) {
        if(list.size()==num.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i=0; i<num.length; i++) {

            if(visited[i]==false) {
                if(i>0 && num[i]==num[i-1] && visited[i-1]==false)
                    continue;
                visited[i] = true;
                list.add(num[i]);
                permute2(num, list, ans, visited);
                list.remove(list.size()-1);
                visited[i] = false;
            }

        }
    }

}
