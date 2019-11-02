package com.tyz.dev.tree.binary;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://www.cnblogs.com/crazylqy/p/7688665.html
 * https://blog.csdn.net/monster_ii/article/details/82115772
 * @param <T>
 */
@Data
public class BTNode<T> {
    T data;
    BTNode<T> left, right;

    public BTNode(T data) {
        this.data = data;
    }


    public static List<BTNode<Integer>> createBinTree() {
        List<BTNode<Integer>> nodeList = new ArrayList<>();
        IntStream.range(1,10).forEach(i->nodeList.add(new BTNode<>(i)));
        int length = nodeList.size() / 2 - 1;
        boolean odd = nodeList.size() % 2 == 1;
        for (int parentIndex = 0; parentIndex <= length; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            //最后一个父节点可能没有右孩子
            if(parentIndex != length || odd){
                // 右孩子
                nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
            }
        }
        return nodeList;
    }
    /**
     * 先序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void preOrderTraverse(BTNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 中序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void inOrderTraverse(BTNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.data + " ");
        inOrderTraverse(node.right);
    }

    /**
     * 后序遍历
     *
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     *
     * @param node
     *            遍历的节点
     */
    public static void postOrderTraverse(BTNode node) {
        if (node == null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data + " ");
    }
    public static void main(String[] args) {

        List<BTNode<Integer>> nodeList = createBinTree();
        // nodeList中第0个索引处的值即为根节点  
        BTNode root = nodeList.get(0);

        System.out.println("先序遍历：");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraverse(root);
    }
}