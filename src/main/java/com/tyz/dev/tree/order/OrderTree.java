package com.tyz.dev.tree.order;

import lombok.Data;

import java.util.*;

/**
 * https://blog.csdn.net/u011445756/article/details/89909780
 */
@Data
public class OrderTree {
    private String name;
    List<OrderTree> children ;
    private OrderTree parent;

    private OrderTree(String name) {
        this.name = name;
    }

    public static OrderTree buildTree(){
        OrderTree root = new OrderTree("A");
        OrderTree b =root.addChildren(new OrderTree("B"));
        OrderTree c =root.addChildren(new OrderTree("C"));
        b.addChildren(new OrderTree("D"));
        OrderTree e = b.addChildren(new OrderTree("E"));
        e.addChildren(new OrderTree("L"));
        c.addChildren(new OrderTree("F"));
        c.addChildren(new OrderTree("G"));
        c.addChildren(new OrderTree("H"));
        return root;
    }
    private OrderTree addChildren(OrderTree node){
        if(this.children == null){
            children = new ArrayList<>();
        }
        this.children.add(node);
        return node;
    }


    public static void main(String[] args) {
        DFSOrder();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
        BFSOrder();
    }

    /**
     * 深度优先遍历各个节点，需要使用到栈（Stack）这种数据结构。stack的特点是是先进后出。整个遍历过程如下：
     *
     * 首先将A节点压入栈中，stack（A）;
     *
     * 将A节点弹出，同时将A的子节点C，B压入栈中，此时B在栈的顶部，stack(B,C)；
     *
     * 将B节点弹出，同时将B的子节点E，D压入栈中，此时D在栈的顶部，stack（D,E,C）；
     *
     * 将D节点弹出，没有子节点压入,此时E在栈的顶部，stack（E，C）；
     *
     * 将E节点弹出，同时将E的子节点I压入，stack（I,C）；
     *
     * …依次往下，最终遍历完成
     */
    public static void DFSOrder(){
        Stack<OrderTree> stack = new Stack();
        OrderTree root = buildTree();
        stack.add(root);
        OrderTree node;
        while (!stack.isEmpty()){
            node  = stack.pop();
            System.out.println(node.getName());
            if(node.getChildren() != null && !node.getChildren().isEmpty()){
                node.getChildren().forEach(n->stack.push(n));
            }
        }
    }

    /**
     * 广度优先遍历各个节点，需要使用到队列（Queue）这种数据结构，queue的特点是先进先出，其实也可以使用双端队列，区别就是双端队列首尾都可以插入和弹出节点。整个遍历过程如下：
     *
     *   首先将A节点插入队列中，queue（A）;
     *
     *   将A节点弹出，同时将A的子节点B，C插入队列中，此时B在队列首，C在队列尾部，queue（B，C）；
     *
     *   将B节点弹出，同时将B的子节点D，E插入队列中，此时C在队列首，E在队列尾部，queue（C，D，E）;
     *
     *   将C节点弹出，同时将C的子节点F，G，H插入队列中，此时D在队列首，H在队列尾部，queue（D，E，F，G，H）；
     *
     *   将D节点弹出，D没有子节点，此时E在队列首，H在队列尾部，queue（E，F，G，H）；
     *
     *   ...依次往下，最终遍历完成
     */
    public static void BFSOrder(){
        Deque<OrderTree> nodeDeque = new ArrayDeque<>();
        OrderTree root = buildTree();
        nodeDeque.add(root);
        OrderTree node;
        while (!nodeDeque.isEmpty()) {
            node = nodeDeque.removeFirst();
            System.out.println(node.getName());
            if(node.getChildren() != null && !node.getChildren().isEmpty()){
                node.getChildren().forEach(n->nodeDeque.add(n));
            }
        }
    }
}
