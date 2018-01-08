package leetcode.tree;

/**
 * 功能描述：Implement a trie with insert, search, and startsWith methods.

 Note:
 You may assume that all inputs are consist of lowercase letters a-z
 *
 * @Author SJ
 * @Date 2018-1-7
 */
public class Trie {

    class Node {

        char val;
        Node link[]= new Node[26];
        boolean isWord = false;

        public Node(char val) {
            this.val = val;
        }
    }

    public Node root = null;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        Node p = root;
        int i=0;
        for(i=0; i<word.length(); i++) {
            char cur = word.charAt(i);
            if(p.link[cur-'a']==null) {
                p.link[cur-'a']=new Node(cur);
            }
            p=p.link[cur-'a'];
        }

        if(i==word.length()) {
            p.isWord=true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        Node p = root;
        boolean found = true;

        int i=0;

        for(i=0; i<word.length(); i++) {
            char cur = word.charAt(i);
            if(p.link[cur-'a']==null) {
                found = false;
                break;
            }


            p=p.link[cur-'a'];

        }

        if(i==word.length()) {
            found = p.isWord;
        }

        return found;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        Node p = root;
        boolean isPrefix = true;

        for(int i=0; i<prefix.length(); i++) {
            char cur = prefix.charAt(i);
            if(p.link[cur-'a']==null) {
                isPrefix=false;
                break;
            }
            p=p.link[cur-'a'];
        }

        return isPrefix;
    }
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
