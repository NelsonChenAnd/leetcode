package leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：
 *
 * @Author SJ
 * @Date 2018-6-7
 */
public class CombinationSumIII {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        if(k>=10||k<=0||n<k||n>9*k){
            return ans;
        }
        backTracing(1, 0, n, k, new ArrayList<Integer>());
        return ans;
    }

    public void backTracing(int start, int sum, int target, int cnt, List<Integer> list) {

        if(sum==target && cnt==list.size()) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i=start; i<=9; i++) {
            if(sum+i<=target && list.size()<cnt) {
                list.add(i);
                backTracing(i+1, sum+i, target, cnt, list);
                list.remove((Integer)i);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        System.out.println(combinationSumIII.combinationSum3(3, 9));
        System.out.println(combinationSumIII.ans);
    }
}
