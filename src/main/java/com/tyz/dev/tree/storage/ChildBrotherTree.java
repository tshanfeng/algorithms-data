package com.tyz.dev.tree.storage;

public class ChildBrotherTree<T> {
    private final static int MAX_TREE_SIZE = 100;
    /**
     * 根位置
     */
    private int root;
    /**
     * 结点数目
     */
    private int num;
    //表头
    private CBDataNode<T>[] nodes;
    public ChildBrotherTree() {
        nodes = new CBDataNode[MAX_TREE_SIZE];
    }
}
class CBDataNode<T> extends DataNode<T>{
    CNode rightsib;
}