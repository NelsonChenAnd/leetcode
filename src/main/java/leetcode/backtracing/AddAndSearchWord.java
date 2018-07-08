package leetcode.backtracing;

import java.util.Arrays;

/**
 * 功能描述：
 *
 * @Author SJ
 * @Date 2018-6-7
 */


class WordDictionary {

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    TrieNode root = new TrieNode();

    public WordDictionary() {
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

        TrieNode p = root;

        for(int i=0; i<word.length(); i++) {
            char cur = word.charAt(i);
            int index = cur-'a';
            if(p.children[index]==null) {
                p.children[index] = new TrieNode();
            }
            p=p.children[index];
        }
        p.item=word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(root, 0, word);
    }


    private boolean dfs(TrieNode node, int start, String word) {
        if(start==word.length()) {
            return !node.item.equals("");
        }

        boolean flag = false;

        if(word.charAt(start) == '.') {
            for(int i=0; i<26; i++) {
                if(node.children[i]!=null && dfs(node.children[i], start+1, word)) {
                    flag = true;
                }
            }
        } else {
            if(node.children[word.charAt(start)-'a']!=null) {
                flag = dfs(node.children[word.charAt(start)-'a'], start+1, word);
            }
        }
        return flag;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
public class AddAndSearchWord {

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("mad");
        dict.addWord("dad");
        System.out.println(dict.search("pad"));
        System.out.println(dict.search("bad"));
        System.out.println(dict.search(".ad"));
        System.out.println(dict.search("b.."));
    }
}
