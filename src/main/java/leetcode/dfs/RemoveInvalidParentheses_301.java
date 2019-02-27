package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: SJ
 * Date: 2019/1/25
 *
 * 难度等级：Hard
 *
 * 思路：DFS 实现。
 *
 * 设置一个counter。遇到(,counter++；遇到)，counter--。
 *
 * Remove the minimum number of invalid parentheses in order to make
 * the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 *
 * Input: ")("
 * Output: [""]
 *
 */
public class RemoveInvalidParentheses_301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        if(s==null) {
            return ans;
        }

        remove(ans, s, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(List<String> ans, String s, int left_i, int left_j, char[] c) {

        int count = 0;
        for(int i=left_i; i<s.length(); i++) {
            // 明确指定c[0], c[1]，是因为还可能会有其他字符出现
            if(s.charAt(i)==c[0]) {
                count++;
            } else if(s.charAt(i) ==c[1]){
                count--;
            }
            if(count>=0) {
                continue;
            }
            for(int j=left_j; j<=i; j++) {
                if(s.charAt(left_j)==c[1] || s.charAt(j)==c[1] && s.charAt(j-1)!=c[1]) {
                    remove(ans, s.substring(0, j)+s.substring(j+1), i, j, c);
                }
            }
            return;
        }

        String reversed = new StringBuffer(s).reverse().toString();
        if(c[0]=='(') {
            remove(ans, reversed, 0, 0, new char[]{')', '('});
        } else {
            ans.add(reversed);
        }
    }

    public static void main(String[] args) {
        String s = "()()))";
        RemoveInvalidParentheses_301 a = new RemoveInvalidParentheses_301();
        List<String> ans = a.removeInvalidParentheses(s);
        System.out.println(ans);
    }
}
