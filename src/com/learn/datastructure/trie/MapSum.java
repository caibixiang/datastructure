package com.learn.datastructure.trie;

import java.util.HashMap;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-24 09:58 caibixiang Exp $
 */
public class MapSum {


 /*   class Node {
        private boolean isWord;
        private Map<Character, Node> next;

      public Node(boolean isWord){
          this.isWord=isWord;
          next=new TreeMap<>();
      }
      public Node(){
          this(false);
      }
    }
*/


    public MapSum() {
        this.map = new HashMap<>();
    }


    private HashMap<String, Integer> map;


    public void insert(String key, int val) {
        map.put(key, val);
    }

    public Integer sum(String prefix) {
        int sum = 0;
        int length = prefix.length();
        for (String key : map.keySet()) {
            int i = 0;
            for (; i < length; i++) {
                if (key.length()<length||prefix.charAt(i) != key.charAt(i))
                    break;
            }
            if (i == length)
                sum =sum +map.get(key);
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)

    }


}
