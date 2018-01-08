package leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        ladder.ladderLength("", "", null);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<Integer> queue = new ArrayList<Integer>();


        System.out.println(queue);System.out.println(queue);
        return -1;
    }

    private void addNextWord() {

    }
}
