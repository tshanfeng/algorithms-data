package com.tyz.dev.tree.storage;

/**
 * 孩子表示法
 * @param <T>
 */
public class ChildTree<T> {
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
    private DataNode<T>[] nodes;
    public ChildTree() {
        nodes = new DataNode[MAX_TREE_SIZE];
    }
}
class DataNode<T>{
    T data;
    CNode firstChild;
}

class CNode<T>{
    CNode<T> next;
    int child;

}

