package com.learn.datastructure.trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-23 21:08 caibixiang Exp $
 */
public class TreeLeetCode {
    private Node root;


    private class Node {
        private boolean isWord;
        private Map<Character, Node> next = new TreeMap<>();

        public Node(Boolean isWord) {
            this.isWord = isWord;
        }

        public Node() {
            this(false);
        }


    }


    public TreeLeetCode() {
        this.root = new Node();
    }

    public void insert(String word) {
        int length = word.length();
        Node cur = root;
        for (int i = 0; i < length; i++) {
            Character character = word.charAt(i);
            if (cur.next.get(character) == null)
                cur.next.put(character, new Node());
            cur = cur.next.get(character);
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }


    }

    public boolean search(String word) {
         Node cur=root;
         int length=word.length();
         for(int i=0;i<length;i++){
             Character character=word.charAt(i);
             if(cur.next.get(character)==null)
                 return false;
             cur= cur.next.get(character);
         }
         return cur.isWord;

    }

    public boolean startsWith(String prefix) {

        Node cur=root;
        int length=prefix.length();
        for(int i=0;i<length;i++){
            Character character=prefix.charAt(i);
            if(cur.next.get(character)==null)
                return false;
            cur= cur.next.get(character);
        }
        return true;


    }
}
