package com.tyz.dev.tree.storage;

public class ParentChildTree<T> {
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
    private PCDataNode<T>[] nodes;
    public ParentChildTree() {
        nodes = new PCDataNode[MAX_TREE_SIZE];
    }
}

class PCDataNode<T> extends DataNode<T>{
    private int parent;
}