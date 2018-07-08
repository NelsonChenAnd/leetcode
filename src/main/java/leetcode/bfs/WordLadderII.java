package leetcode.bfs;

import java.util.*;

/**
 * 功能描述：给定两个词（起始词和结束词），一个词列表；每次转换一个字符，转换后的词在列表中。
 *          找出最短转换序列。
 *
 *          假定：
 *          1）如果没有转换序列，返回空列表
 *          2）所有的单词长度相同。
 *          3）所有的单词包含小写字符
 *          4）单词列表中不包含重复单词
 *          5）假设起始词和结束词都不为空并且不同。
 *
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * @Author SJ
 * @Date 2018-5-28
 */
public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> wordDict = new HashSet<>(wordList);
        Set<String> addedSet = new HashSet<>();
        addedSet.add(beginWord);

        HashMap<String, List<List<String>>> last2ListMap = new HashMap<>();

        List<String> base = new ArrayList<String>();
        base.add(beginWord);
        List<List<String>> baseList = new ArrayList<>();
        baseList.add(base);
        last2ListMap.put(beginWord, baseList);

        List<List<String>> globalList = new ArrayList<>(baseList);

        int minLen = 0;
        while(wordDict.contains(endWord)) {

            Set<String> toAdd = new HashSet<>();

            for(String word: addedSet) {

                List<String> wordIter = new ArrayList<>();

                for(int i=0; i<word.length(); i++) {
                    char[] charArr = word.toCharArray();
                    for(char ch='a'; ch<='z'; ch++) {
                        if(charArr[i]==ch)
                            continue;
                        charArr[i] = ch;
                        String tranWord = new String(charArr);
                        if(wordDict.contains(tranWord)) {
                            toAdd.add(tranWord);

                            wordDict.remove(tranWord);
                            if(tranWord.equals(endWord)) {
                                wordDict.add(endWord);
                            }
                            wordIter.add(tranWord);
                        }
                    }
                }

                List<List<String>> list = last2ListMap.get(word);
                last2ListMap.remove(word);

                for(String w: wordIter) {
                    List<List<String>> newList = new ArrayList<>();
                    for(List l: list) {
                        List<String> oneSeq = new ArrayList<>(l);
                        oneSeq.add(w);
                        newList.add(oneSeq);
                    }

                    if(last2ListMap.containsKey(w)) {
                        last2ListMap.get(w).addAll(newList);
                    } else {
                        last2ListMap.put(w, newList);
                    }
                }

                System.out.println(word + "\t" + wordIter + "\t" + wordDict + "\t" + last2ListMap);

            }
            addedSet = toAdd;
        }

        return last2ListMap.get(endWord);
    }

    public static void main(String[] args) {

        WordLadderII wordLadderII = new WordLadderII();

        String beginWord = "hit";
        String endWord = "cog";
        String[] wordArr = {"hot", "dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>();

        for(int i=0; i<wordArr.length; i++) {
            wordList.add(wordArr[i]);
        }
        System.out.println(wordLadderII.findLadders(beginWord, endWord, wordList));
    }
}
