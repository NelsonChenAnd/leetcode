package leetcode.dp;

public class UniqueSubstringsInWraparoundString {
    /**
     * 已知一个字符串p
     * p中字符满足
     * ....abcdefghijk...xyzabcd...这个顺序的子串的distinct数目。
     *
     * 例如：
     * Input: aca
     * Out: 2 a,c
     *
     * cnt[i] 表示以p[i]为结尾的最大顺序子串数。
     *
     * @param p
     * @return
     */
    public static int findSubstringInWraproundString(String p) {
        if(p.length()<=0) {
            return 0;
        }

        int cnt[] = new int[26];
        int maxLen = 0;
        for(int i=0; i<p.length(); i++) {
            if(i==0) {
                maxLen=1;
                cnt[p.charAt(i)-'a']=1;
                continue;
            }
            if(p.charAt(i)==p.charAt(i-1)+1 || p.charAt(i)+25==p.charAt(i-1)) {
                maxLen++;
            } else {
                maxLen=1;
            }

            cnt[p.charAt(i)-'a'] = Math.max(maxLen, cnt[p.charAt(i)-'a']);
        }

        int sum=0;

        for(int i=0; i<cnt.length; i++)   {
            sum += cnt[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.print(findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
                "abcdefghijklmnopqrstuvwxyz"));
    }
}
