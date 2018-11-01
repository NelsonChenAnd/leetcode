package leetcode.dp;

public class LargestSumOfAverages {
    /**
     * 给定一个数组，将数组划分成K 组，使得各组的平均值 加起来最大，求最大得分。
     *
     * K 怎么用，多个分组怎么处理？
     *
     * dp[i][j] 代表前i个元素划分成j个分组的最大得分。
     * 则dp[i][k] = Math.max(dp[t, k-1] + (sum[i]-sum[t])/(i-t)) [t 从  k -> i-1]
     *
     *  @param A
     * @param K
     * @return
     */
    public static double largestSumOfAverages(int[] A, int K) {
        if(A.length==0) {
            return 0;
        }
        int sum[] = new int[A.length];
        for(int i=0; i<A.length; i++) {
            if(i==0) {
                sum[i] = A[i];
            } else {
                sum[i] = sum[i - 1] + A[i];
            }
        }
        double dp[][] = new double[A.length+1][K+1];
        for(int i=1; i<=A.length; i++) {
            dp[i][1] = 1.0*sum[i-1]/i;
        }

        for(int k=2; k<=K; k++) {
            for(int i=k; i<=A.length; i++) {
                for(int t=k-1; t<i; t++) {
                    dp[i][k] = Math.max(dp[t][k-1]+1.0*(sum[i-1]-sum[t-1])/(i-t), dp[i][k]);
                }
            }
        }
        return dp[A.length][K];
    }

    public static void main(String[] args) {
        System.out.println(largestSumOfAverages(new int[]{9, 1, 2, 3, 9},
                3));
    }
}
