package com.learn.datastructure.linkedlist;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-05 18:02 caibixiang Exp $
 */
public class LinkedList<E> {

    private Node dummyHead;
    private int size;


    public LinkedList() {
        this.dummyHead = new Node(null);
        this.size = 0;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //在链表头添加新元素e
    public void addFirst(E e) {
        /*Node node =new Node(e);
        node.next=head;
        head=node;*/
        add(0, e);
    }

    //在链表的index(0-based)位置添加的新的元素e
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void removeElement(E e) {
        Node pre = dummyHead;
        for (int i = 0; i < size; i++) {
            Node node = pre.next;
            if (node.e.equals(e)) {
                pre.next = pre.next.next;
                return;
            }
            pre = pre.next;
        }
    }


    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("remove failed.Illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }


    public void addLast(E e) {
        add(size, e);
    }


    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }


    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("set failed. Illegal index");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否元素
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {

        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


}
