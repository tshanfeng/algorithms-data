package com.tyz.dev.tree.storage;

/**
 * https://www.cnblogs.com/ssyfj/p/9459887.html
 * 以双亲作为索引的关键词的一种存储方式
 * 每个结点只有一个双亲，所以选择顺序存储占主要
 * 以一组连续空间存储树的结点，同时在每个结点中，附设一个指示其双亲结点位置的指针域
 */
public class ParentTree<T> {
    private final static int MAX_TREE_SIZE = 100;
    /**
     * 根位置
     */
    private int root;
    /**
     * 结点数目
     */
    private int num;
    /**
     * 结点数组
     */
    private PNode<T>[] nodes;
    public ParentTree() {
        nodes = new PNode[MAX_TREE_SIZE];
    }
}

class PNode<T>{
    T data;
    int parent;

}
