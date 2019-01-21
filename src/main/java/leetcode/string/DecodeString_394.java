package leetcode.string;

/**
 * Author: SJ
 * Date: 2019/1/2
 *
 * Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string
 * inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra
 * white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain
 * any digits and that digits are only for those repeat numbers, k.
 *
 * For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * 2 cc
 * 3 a
 * s = "leetcode" return "leetcode"
 * s = "3[a]2[bc]", return "aaabcbc". ans = aaa
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString_394 {

    private static int start = 0;
    public static String decodeString(String s) {
        if(s==null||s.length()==0) {
            return s;
        }
        return decode(s);
    }

    public static String decode(String s) {

        String res = "";

        while(start<s.length() && s.charAt(start)!=']') {
            if(!Character.isDigit(s.charAt(start))) {
                res += s.charAt(start++);
            } else {
                int cnt = 0;
                while(Character.isDigit(s.charAt(start))) {
                    cnt=cnt*10 + s.charAt(start)-'0';
                    start++;
                }

                start++;
//                System.out.println(cnt + "\t" + s.charAt(start));
                String inner = decode(s);
//                System.out.println(inner);
                start++;

                for(int i=0; i<cnt; i++) {
                    res += inner;
                }
//                System.out.println(res + "\t" + inner + "\t"+start);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String in = "leetcode";
//        in = "3[a2[c]]";
        in = "2[abc]3[cd]ef";
        in = "3[a]2[b4[F]c]";
        in = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String s = decodeString(in);

        System.out.println(s);
    }
}
