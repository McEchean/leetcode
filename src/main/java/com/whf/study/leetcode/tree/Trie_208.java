package com.whf.study.leetcode.tree;

/**
 * 别人花了6分钟  我花了一小时？？？
 */
public class Trie_208 {
    private static class Tree {
        private int val;
        private Tree[] next;
        private String world;

        public Tree(int val) {
            this.val = val;
            this.next = new Tree[26];
        }
    }

    private Tree[] tire;

    /**
     * Initialize your data structure here.
     */
    public Trie_208() {
        this.tire = new Tree[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Tree[] ts = this.tire;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 97;
            Tree t = ts[c];
            if(t == null) {
                t = new Tree(1);
                t.next = new Tree[26];
                ts[c] = t;
            }
            ts = t.next;
            if(i == word.length() - 1) {
                t.world = word;
            }
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Tree[] ts = this.tire;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 97;
            Tree t = ts[c];
            if (t == null) {
                return false;
            }
            ts = t.next;
            if(i == word.length() - 1 && t.world == null) {
               return false;
            }
        }
        return true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Tree[] ts = this.tire;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 97;
            Tree t = ts[c];
            if (t == null) {
                return false;
            }
            ts = t.next;
        }
        return true;
    }


    public static void main(String[] args) {
        Trie_208 trie_208 = new Trie_208();
        trie_208.insert("app");
        trie_208.insert("apple");
        trie_208.insert("beer");
        trie_208.insert("add");
        trie_208.insert("jam");
        trie_208.insert("rental");
        boolean app = trie_208.search("apps");
        System.out.println(app);
        boolean app1 = trie_208.search("app");
        System.out.println(app1);
        boolean a = trie_208.startsWith("apl");
        System.out.println(a);
    }
}
