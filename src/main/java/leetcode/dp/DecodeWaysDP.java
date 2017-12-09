package leetcode.dp;

public class DecodeWaysDP {

    /**
     * 有以下映射关系，
'A' -> 1
'B' -> 2
...
'Z' -> 26
假设给出数字信息s，从中进行解码，可能的解码方式有几个？
如给出s为“12”，可以解码成 “AB”  或 “L”。

     * 思路：
     * 采用动态规划求解。
     * 数组dp[];
     * 初始化：
     * dp[0]=0;
     * 动态转移方程：
     * dp[i+1]=dp[i]+1 i>=0
     *                 i>0 && s[i]=='1'
     * @param  //String s          给定数字编码
     * @return       有多少个编码
     */
    public int numDecodings(String s) {
        if(s==null || s.length()<=0)
            return 0;
        int dp[]=new int[s.length()+1];

        if(s.charAt(0)=='0') {
            dp[1]=0;
        } else {
            dp[1]=1;
        }
        dp[0]=1;

        for(int i=1; i<s.length();i++) {
            if(s.charAt(i)=='0') {
                if(s.charAt(i-1)=='0' || s.charAt(i-1)>='3') {
                    return 0;
                } else {
                    dp[i+1] = dp[i-1];
                }
            } else if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2' && s.charAt(i)>='0' && s.charAt(i)<='6') {
                dp[i+1] = dp[i] + dp[i-1];
            } else {
                dp[i+1] = dp[i];
            }
        }

        return dp[s.length()];
    }
}
