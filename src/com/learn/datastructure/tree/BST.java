package com.learn.datastructure.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-06 21:56 caibixiang Exp $
 */
public class BST<E extends Comparable> {

    private Node root;
    private int size;

    private class Node {
        public E val;
        private Node right;
        private Node left;

        public Node(E e) {
            this.val = e;
            right = null;
            left = null;
        }

    }


    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
       /* if (root == null) {
            root = new Node(e);
            size++;
        } else
            add(root, e);*/
        root = addNode(root, e);

    }

    //向以node为根的二分搜索树中插入元素E,递归算法
    private void add(Node node, E e) {
        if (e.equals(node.val))
            return;
        else if (e.compareTo(node.val) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.val) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.val) < 0)
            add(node.left, e);
        else
            add(node.right, e);

    }


    private Node addNode(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.val) < 0)
            node.left = addNode(node.left, e);
        else if (e.compareTo(node.val) > 0)
            node.right = addNode(node.right, e);
        return node;
    }

    public boolean contains(E e) {
        return find(root, e);
    }

    private boolean find(Node node, E e) {
        if (node == null)
            return false;

        if (node.val.compareTo(e) < 0)
            return find(node.left, e);
        else if (node.val.compareTo(e) > 0)
            return find(node.right, e);
        else
            return true;

    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);

    }

    // 二分搜索树的中序遍历结果是顺序的
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);

    }

    /**
     * 后序遍历的一个应用：
     * 为二分搜索树释放内存
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);

    }


    //二分搜索树遍历的非递归实现,比递归实现复杂很多
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while ((!stack.isEmpty())) {
            Node cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }


    //返回以node为根的二分搜索树的最小值所在的节点
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).val;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).val;
    }

    private Node maximum(Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    //从 二分搜索树中删除最小值所在节点，返回最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }


    //向以node为根的二分搜索树中插入元素e,递归算法
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

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;

    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);

    }

    private Node remove(Node node, E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.val) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.val) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { // e==node.val
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
            } else { // 左右子节点都不为空
                // 找到比待删除节点大的最小节点 即 删除结点右子树的最小结点 或者前驱
                // 用这个节点替代删除
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = null;
                node.right = null;
                return successor;
            }
        }
    }

    /**
     * 广度优先遍历的意义
     * 更快的找到问题的解
     * 常用用于算法设计中 - 最短路径
     * 图中的深度优先遍历和广度优先遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.val);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null \n");
            return;
        }
        res.append(generateDepthString(depth) + node.val + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
