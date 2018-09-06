package leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * 注意几点：
 * 1） int 可能会溢出，所以最好使用long来计算。
 * 2） 多个字符构成十位数、百位数也可以计算。 如 “105” 和 5  结果 1*0+5, 10-5
 * 3） 乘法前第一个+/- 要记录下来，当现有字符是*时才能正确恢复加减乘数前的结果
 * 4） 对于第一个数要特殊处理。
 */
public class ExpressionAddOperators {

    //""2147483648"
    //-2147483648
    public static void main(String[] args) {
        ExpressionAddOperators operators = new ExpressionAddOperators();
        System.out.println(operators.addOperators("2147483648", -2147483648));
    }

    private char[] op={'+', '-', '*'};

    public List<String> addOperators(String num, int target) {

        List<String> list = new ArrayList<String>();

        if(num==null || num.length()<=0) {
            return list;
        }

        long mult = 1;
        long ans = 0;
        StringBuffer buf = new StringBuffer();

        for(int i=0; i<num.length(); i++) {
            String firstNum = num.substring(0, i+1);
            if(firstNum.charAt(0)=='0' && i>0) {
                break;
            }


            ans = Long.parseLong(firstNum);
//            System.out.println(">>>" + firstNum + "\t" +ans + "\t" + (int)(ans));
            mult = Long.parseLong(firstNum);
            buf.append(ans);
            dfs(num, i+1, ans, buf, mult, list, target, '+');
            buf.delete(0, i+1);
        }

        return list;
    }

    /**
     *
     * @param num 输入字符串
     * @param start 下一个待计算数字所处的第一个字符
     * @param ans 到目前为止计算出来的结果
     * @param buf 拼接算式字符串
     * @param mult 乘数
     * @param list 结果列表
     * @param target 输入目标数字
     * @param lastOp 上一个+或-
     */
    private void dfs(String num, int start, long ans, StringBuffer buf, long mult, List<String> list, int target, char lastOp) {
        if(start==num.length()) {
            if(ans==target) {
                list.add(buf.toString());
            }
            return;
        }


        for(int j=1; start+j<=num.length(); j++) {

            String localNum = num.substring(start, start+j);
            if(localNum.charAt(0)=='0' && j>1) {
                break;
            }
            for(char c: op) {

                buf.append(c);
                buf.append(localNum);

                if(c=='+') {
                    dfs(num, start+j, ans + Long.parseLong(localNum), buf, Long.parseLong(localNum), list, target, c);
                } else if(c=='-') {
                    dfs(num, start+j, ans - Long.parseLong(localNum), buf, Long.parseLong(localNum), list, target, c);
                } else if(c=='*') {
                    dfs(num, start+j, lastOp=='+'? ans - mult + mult * (Long.parseLong(localNum)): ans + mult - mult * (Long.parseLong(localNum)), buf, mult*(Long.parseLong(localNum)), list, target, lastOp);
                }
                buf.deleteCharAt(buf.length()-1);
                buf.delete(buf.length()-j, buf.length());
            }

        }
    }

}
