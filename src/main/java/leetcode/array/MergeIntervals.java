package leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 功能描述：
 *
 * @Author SJ
 * @Date 2017-12-4
 */
public class MergeIntervals {

    public static class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "[" + start +
                    ", " + end +
                    "]";
        }
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(1,4));
        list.add(new Interval(0, 4));
//        list.add(new Interval(8, 10));
//        list.add(new Interval(15, 18));
        System.out.println(Solution.merge(list));
    }
    static class Solution {

        public static List<Interval> merge(List<Interval> intervals) {
            if(intervals==null||intervals.size()==0) {
                return intervals;
            }
            Collections.sort(intervals, new Comparator<Interval>() {
                public int compare(Interval o1, Interval o2) {
                    if(o1.start>o2.start) {
                        return 1;
                    } else if(o1.start<o2.start){
                        return -1;
                    } else
                        return 0;
                }
            });
            System.out.println(intervals);
            List<Interval> ans = new ArrayList<Interval>();

            int left=Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;

            for(int i=0; i< intervals.size(); i++) {
                Interval interval = intervals.get(i);
                if(i==0) {
                    left = interval.start;
                    right = interval.end;
                } else {
                    if(interval.start <= right) {
                        right = Math.max(right, interval.end);
                    } else {
                        ans.add(new Interval(left, right));
                        left = interval.start;
                        right = interval.end;
                    }
                }
            }

            ans.add(new Interval(left, right));
            return ans;
        }
    }
}
