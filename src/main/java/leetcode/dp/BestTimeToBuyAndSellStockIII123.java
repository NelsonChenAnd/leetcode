package leetcode.dp;

/**
 * 功能描述：
 * 4 Variables to maintain some interested 'ceilings' so far:
 * The maximum of
 *      if we've just buy 1st stock,
 *      if we've just sold 1nd stock,
 *      if we've just buy 2nd stock,
 *      if we've just sold 2nd stock.
 *
 * Very simple code too and work well. I have to say the logic is simple than those in Single Number II
 * @Author SJ
 * @Date 2018-5-23
 */
public class BestTimeToBuyAndSellStockIII123 {


    /**
     * 1. 动态规划方式求解
     * 主要找出状态转移方程：截止到ii为止，最多进行k 次 交易的最大利润dp
     * dp[k, ii] = max{dp[k, ii-1], dp[k-1, jj] + a[ii]-a[jj]} , jj -> [0, ii]
     *= max{dp[k, ii-1],  a[ii] + max{dp[k-1, jj]-a[jj]} )}
     *
     * dp[0, ii] = 0
     * dp[k, 0] = 0
     *
     * @param prices
     * @return
     */
    public int maxProfitDP(int[] prices) {
        if(prices==null||prices.length<=0) {
            return 0;
        }
        int numOfTransactions = 2;
        int dp[][] = new int[numOfTransactions+1][prices.length+1];
        for(int i=0; i<=numOfTransactions; i++) {
            dp[i][0] = 0;
        }
        for(int i=0; i<=prices.length; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<dp.length; i++) {
            int tmpMax= dp[i-1][0]-prices[0]; // 这一步不能不写。。。否则会算错
            for(int j=1; j<dp[i].length; j++) {
                dp[i][j] = Math.max(dp[i][j-1], tmpMax + prices[j-1]);
                if(dp[i-1][j]-prices[j-1]>tmpMax) {
                    tmpMax = dp[i-1][j]-prices[j-1];
                }
            }
        }
        return dp[numOfTransactions][prices.length];
    }


    /**
     * 2. 用4个变量存储的方式，感觉是dp的升级版
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        // release2 截止到当前为止卖掉第二只股票的最大利润。
        // hold2 截止到当前为止买入第二只股票以后的最大利润。
        // release1 截止到当前为止卖掉第1只股票的最大利润。
        // hold1 截止到当前为止买入第2只股票的最大利润。

        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }


    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII123 b = new BestTimeToBuyAndSellStockIII123();
        int[] data = {2, 1, 6, 3, 5, 7};

        System.out.println(b.maxProfit(data));
        System.out.println(b.maxProfitDP(data));
    }

}
