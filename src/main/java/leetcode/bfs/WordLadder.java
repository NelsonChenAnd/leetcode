package leetcode.bfs;

import java.util.*;

/**
 * 功能描述：
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * @Author SJ
 * @Date 2017-12-27
 */
public class WordLadder {

    public static void main(String[] args) {
        WordLadder ladder = new WordLadder();
        List<String> list = new ArrayList<>();


        list.add("hot");
        list.add("dot");
        list.add("dog");
//        list.add("lot");
//        list.add("log");
        list.add("cog");
        list.add("tot");
        list.add("hog");
        list.add("hop");
        list.add("pot");
        Set<String> set = new HashSet<>();
        List<String> l = new ArrayList<>(set);

        System.out.println("set is => " + set);
        System.out.println("list is => " + l);
        int words = ladder.ladderLength("hot", "dog", list);
        System.out.println(words);
    }



    /**
     * 从beginWord 到 endWord 转换次数
     * @param beginWord
     * @param endWord
     * @param wordDict
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordDict) {

        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordDict.add(endWord);
        int distance = 1;

        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }
}
