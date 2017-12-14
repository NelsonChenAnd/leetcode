package leetcode.array;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 * @Link https://leetcode.com/problems/insert-interval/description/
 * 思路，
 * 1. 先找到当前 newInterval 应该插入的位置。
 * 2. 合并包含 newInterval 在内所有可以合并的 Interval。
 * 3. 剩余的 Interval 追加到结果。
 */


public class InsertInterval {
    /**
     * Definition for an interval.
     */
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<Interval>();
        int i=0, start=newInterval.start, end=newInterval.end;
        while(i<intervals.size() && intervals.get(i).end < newInterval.start) {
            ans.add(intervals.get(i));
            i++;
        }

        while(i<intervals.size() && intervals.get(i).start<=newInterval.end) {
            start=Math.min(intervals.get(i).start, start);
            end=Math.max(intervals.get(i).end, end);
            i++;
        }
        Interval temp = new Interval(start, end);
        ans.add(temp);

        while(i<intervals.size()) {
            ans.add(intervals.get(i++));
        }
        return ans;
    }

    public static void main(String[] args) {
        InsertInterval s = new InsertInterval();
        List<Interval> list = new ArrayList<Interval>();
        list.add(s.new Interval(1,3));
        list.add(s.new Interval(6,9));
        s.insert(list, s.new Interval(2,5));
    }

}
