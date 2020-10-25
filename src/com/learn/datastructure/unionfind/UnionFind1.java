package com.learn.datastructure.unionfind;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-24 17:16 caibixiang Exp $
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++)
            id[i] = i;
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override  //O(1)
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 查找元素p对应的集合编号
    private int find(int p) {
        if (p < 0 && p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");
        return id[p];
    }

    @Override  //O(n)
    public void unionElement(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (qId == pId)
            return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pId)
                id[i] = qId;


    }
}
