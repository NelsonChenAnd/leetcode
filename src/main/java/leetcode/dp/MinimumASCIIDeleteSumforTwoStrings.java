package leetcode.dp;

import com.sun.xml.internal.ws.util.ASCIIUtility;

/**
 * 获取一个字符的ASCII 码， 采用Integer.valueOf(c)来实现。
 */
public class MinimumASCIIDeleteSumforTwoStrings {

//    https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/

    /**
     * 求两个字符串删除一定字符后相同，两个字符串删除的字符ASCII码的最小和。
     * 子串问题。
     * Input: s1 = "delete", s2 = "leet"
     * Output: 403
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int minimumDeleteSum(String s1, String s2) {
        if(s1.length()<=0 && s2.length()<=0) {
            return 0;
        }

        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=1; i<=s2.length(); i++) {
            dp[0][i] = dp[0][i-1] + Integer.valueOf(s2.charAt(i-1));
        }
        for(int i=1; i<=s1.length(); i++) {
            dp[i][0] = dp[i-1][0] + Integer.valueOf(s1.charAt(i-1));
        }

        for(int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
                if(s1.charAt(i-1)!=s2.charAt(j-1)) {
                    dp[i][j] = Math.min(dp[i-1][j] + Integer.valueOf(s1.charAt(i-1)),
                            Math.min(dp[i][j-1] + Integer.valueOf(s2.charAt(j-1)),
                                    dp[i-1][j-1] + Integer.valueOf(s1.charAt(i-1) + s2.charAt(j-1))));
                } else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("delete", "leet"));
    }
}
