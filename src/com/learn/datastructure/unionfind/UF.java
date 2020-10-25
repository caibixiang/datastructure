package com.learn.datastructure.unionfind;

/**
 * Description
 *
 * @author caibixiang
 * @version v0.1 2020-10-24 17:10 caibixiang Exp $
 */
public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElement(int p, int q);

}
