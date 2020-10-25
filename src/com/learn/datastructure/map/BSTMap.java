package com.learn.datastructure.map;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-07 22:43 caibixiang Exp $
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {


    @Override
    public void add(K key, V value) {
        root = add(key, value, root);

    }

    private Node add(K key, V value, Node node) {
        if (node == null) {
            node = new Node(key, value);
            size++;
        }
        if (node.key.compareTo(key) < 0) {
            node.left = add(key, value, node.left);
        } else if (node.key.compareTo(key) > 0) {
            node.right = add(key, value, node.right);
        } else {
            node.value = value;// 相同默认更新
        }
        return node;
    }

    private Node getNode(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }


    //通过 后记节点 来删除 successor
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(key, root);
            return node.value;
        }
        return null;
    }

    private Node remove(K key, Node node) {
        if (node == null)
            return null;
        if (node.key.compareTo(key) < 0) {
            return node.left = remove(key, node.left);
        } else if (node.key.compareTo(key) > 0) {
            return node.right = remove(key, node.right);
        } else {

            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else { // 左右子节点都不为null
                Node successor = minimum(node.right);
                successor.left = node.left;
                successor.right = removeMin(node.right);
                node.left = node.right = null;
                return successor;
            }
        }

    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + "doesn't exist!");
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node root;

    private int size;

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

}
