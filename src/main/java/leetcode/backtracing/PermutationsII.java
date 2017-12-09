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
 * 也可以使用visited 数组记录访问过的，访问过的数就不再递归。
 */

class PermutationsII {

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        int nums[] = new int[] {-1,2,0,-1,1,0,1};
        System.out.println(p.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        permute2(nums, 0, ans);
        return new ArrayList<List<Integer>>(ans);
    }

    private void permute2(int[] num, int index, HashSet<List<Integer>> ans) {
        if(index==num.length-1) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<num.length; i++) {
                list.add(num[i]);
            }
            ans.add(list);
            return;
        }

        for(int i=index; i<num.length; i++) {
            if(i>index && num[i]==num[i-1])
                continue;
            swap(num, i, index);
            permute2(num, index+1, ans);
            swap(num, i, index);
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
}
