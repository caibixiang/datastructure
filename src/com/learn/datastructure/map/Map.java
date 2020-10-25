package com.learn.datastructure.map;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-07 22:08 caibixiang Exp $
 */
public interface Map<K, V> {
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();


}
