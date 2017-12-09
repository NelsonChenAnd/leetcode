package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */


public class RestoreIPAddresses {

    public static void main(String[] args) {
        RestoreIPAddresses s = new RestoreIPAddresses();
        System.out.println(s.restoreIpAddresses("0000"));

    }

    /**
     * 调用还原ip地址的入口函数。
     * @param  String s             [description]
     * @return        [description]
     */
    public List<String> restoreIpAddresses(String s) {
        
        ArrayList<String> ans = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();

        int min = 1;
        if(s.length()<=3||s.length()>12) {
            return ans;
        }

        dfs(min, s, 0, 0, ans, list);
        return ans;
    }

    public void dfs(int min, String s, int index, int partIndex, ArrayList<String> ans, ArrayList<String> list) {
        if(partIndex==3) {
            System.out.println("here");
            System.out.println(index +">>>"+s.length());
            if(judge(s.substring(index, s.length()))) {
                System.out.println(list);
                StringBuffer buffer = new StringBuffer();
                for(int i=0;i<list.size();i++) {
                    buffer.append(list.get(i));
                    buffer.append(".");
                }
                buffer.append(s.substring(index, s.length()));
                ans.add(buffer.toString());
                return;
            }
        }
        System.out.println("第 " + partIndex + "层" + index+ "\t"+( min));
        for(int i=min; i<=3; i++) {
            String cur = s.substring(index, Math.min(index+i, s.length()));
            if(judge(cur)) {
                list.add(cur);
                dfs(min, s, Math.min(index+i, s.length()), partIndex+1, ans, list);
                list.remove(list.size()-1);
            }
        }
    }

    /**
     * 判断一个数字字符串是否在0-255之间
     * @param  //String s             [description]
     * @return        [description]
     */
    public boolean judge(String s) {
        if(s.length()>=4) {
            return false;
        }
        if(s.length()<=0)
            return false;
        int temp = Integer.parseInt(s);
        if(s.length()>1 && s.charAt(0)=='0') {
            return false;
        }
        if(temp>=0 && temp<=255) {
            return true;
        } else {
            return false;
        }
    }
}
