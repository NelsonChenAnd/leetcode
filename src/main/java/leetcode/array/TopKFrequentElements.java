package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author: SJ
 * Date: 2019/1/2
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums.length==0) {
            return list;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        List<Integer> tmp[] = new ArrayList[nums.length];
        for(Integer key: map.keySet()) {
            int fre = map.get(key);
            if(tmp[fre]==null) {
                tmp[fre] = new ArrayList<>();
            }
            tmp[fre].add(key);
        }

        for(int i=tmp.length-1; i>=0 && list.size()<k; i--) {
            if(tmp[i]!=null) {
                list.addAll(tmp[i]);
            }
        }
        return list.subList(0, k);

    }
}
