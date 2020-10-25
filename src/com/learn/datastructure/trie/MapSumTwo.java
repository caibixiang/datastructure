package com.learn.datastructure.trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-24 14:05 caibixiang Exp $
 */
public class MapSumTwo {


    private class Node {
        private Integer value;
        private Map<Character, Node> next;

        public Node(Integer val) {
            this.value = val;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }

    }

    private Node root;

    public MapSumTwo() {
        this.root = new Node();
    }


    public void insert(String key, int val) {
        Node cur = root;
        int length = key.length();
        for (int i = 0; i < length; i++) {
            if (cur.next.get(key.charAt(i)) == null)
                cur.next.put(key.charAt(i), new Node());
            cur = cur.next.get(key.charAt(i));
        }
        cur.value = val;
    }


    public int sum(String prefix) {
        Node node = root;
        int length = prefix.length();
        for (int i = 0; i < length; i++) {
            if (node.next.get(prefix.charAt(i)) == null)
                return 0;
            node = node.next.get(prefix.charAt(i));
        }

        return sum(node);
    }


    public int sum(Node node) {
        int res = node.value;
        for (Character c : node.next.keySet()) {
            res +=sum(node.next.get(c));
        }
        return res;

    }


    public static void main(String[] args) {
        MapSumTwo mapSum = new MapSumTwo();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));

    }
}
