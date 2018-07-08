package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 功能描述：
 *
 * @Author SJ
 * @Date 2018-6-26
 */
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int cnt=0;
        for(int i=citations.length-1; i>=0; i--) {
            if(citations[i]>=cnt++) {
                return cnt;
            }
        }
        return 0;
    }
}
