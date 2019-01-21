package leetcode.dfs;

public class DecodeWays {

    /**
     * 有以下映射关系，
'A' -> 1
'B' -> 2
...
'Z' -> 26
假设给出数字信息s，从中进行解码，可能的解码方式有几个？
如给出s为“12”，可以解码成 “AB”  或 “L”。

     * 思路：
     * 此处用递归方式求解，要注意的细节很多。
     * 需要考虑一些特殊情况，比如
     * 1.0的处理，
     * 2.字符串如果为空的处理
     * @param   s          给定数字编码
     * @return       有多少个编码
     */
    public int numDecodings(String s) {
        if(s==null || s.length()<=0)
            return 0;
        return dfs(s, 0, 0);
    }

    public int dfs(String s, int index, int count) {

        int j=index;

        for(j=index; j<s.length();j++) {
            if(s.charAt(j)>='3' && s.charAt(j)<='9') {
                continue;
            } else {
                break;
            }
        }
        index=j;

        if(index<s.length() && s.charAt(index)=='0') {
            return 0;
        }


        if(index == s.length()-1 || index >= s.length()) {
            return 1;
        }
        if(s.charAt(index)=='1' || (index+1<s.length() && s.charAt(index)=='2' && s.charAt(index+1)<='6')) {
            count+= dfs(s, index+1, count)+dfs(s, index+2, count);
        } else if(s.charAt(index)>='3' && s.charAt(index)<='9') {
            count+=dfs(s, index+1, count);
        } else if(index+1<s.length() && s.charAt(index)=='2' && s.charAt(index+1)>'6') {
            count+=dfs(s, index+2, count);
        }
        return count;
    }
}
