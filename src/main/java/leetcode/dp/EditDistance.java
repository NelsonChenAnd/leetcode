
package leetcode.dp;

public class EditDistance {

    /**
     * 状态转移方程：dp[i+1][j+1], 遍历到 word1 的 i 下标和 word2 的 j 下标时，最小的改动步数step。
     * 初始化：
     * 1. dp[0][0]=0;
     * 2. dp[i][0]=i; for i 从1到word1.length();
     * 3. dp[0][i]=i; for i 从1到word2.length();
     * 状态转移方程:
     * dp[i+1][j+1]=min{dp[i][j+1], dp[i][j], dp[i+1][j]} + 1
     * @param  String word1         [description]
     * @param  String word2         [description]
     * @return        [description]
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<word1.length()+1; i++) {
            dp[i][0]=i;
        }
        for(int i=0; i<word2.length()+1; i++) {
            dp[0][i]=i;
        }
        for(int i=0; i<word1.length(); i++) {
            for(int j=0; j<word2.length(); j++) {
                if(word1.charAt(i)==word2.charAt(j)) {
                    dp[i+1][j+1]=dp[i][j];
                } else {
                    dp[i+1][j+1]=Math.min(dp[i][j+1], Math.min(dp[i][j], dp[i+1][j]))+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
