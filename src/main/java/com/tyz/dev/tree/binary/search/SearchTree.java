package com.tyz.dev.tree.binary.search;

import com.tyz.dev.tree.binary.BTNode;
import lombok.Getter;

/**
 * https://www.cnblogs.com/Renyi-Fan/p/8185325.html
 * https://www.cnblogs.com/songwenjie/p/8973217.html
 */
@Getter
public class SearchTree  {
    private BTNode<Integer> root;

    /**
     * 把父节点设置为当前节点，即根节点。
     * 如果新节点内的数据值小于当前节点内的数据值，那么把当前节点设置为当前节点的左子节点。
     * 如果新节点内的数据值大于当前节点内的数据值，那么就跳到步骤 4。
     *
     * 如果当前节点的左子节点的数值为空（null），就把新节点插入在这里并且退出循环。否则，跳到 while 循环的下一次循环操作中。
     *
     * 把当前节点设置为当前节点的右子节点。
     * 如果当前节点的右子节点的数值为空（null），就把新节点插入在这里并且退出循环。否则，跳到 while 循环的下一次循环操作中。
     * @param data
     */
    public void insert(int data){
        BTNode<Integer> newNode = new BTNode<>(data);
        if(root == null ){
            root = newNode;
            return;
        }
        BTNode<Integer> current = root;
        while (true){
            if(data < current.getData()){
                if(current.getLeft() == null){
                    current.setLeft(newNode);
                    break;
                }
                current = current.getLeft();
            }else if(data > current.getData()){
                if(current.getRight() == null){
                    current.setRight(newNode);
                    break;
                }
                current = current.getRight();
            }else{
                //相等
                break;
            }
        }
    }

    /**
     * 根据二叉查找树的性质，二叉查找树的最小值一定是在左子树的最左侧子节点。
     * @return
     */
    public Integer findMin(){
        if(root == null){
            return  null;
        }
        BTNode<Integer> current = root;
        while (current.getLeft() != null){
            current = current.getLeft();
        }
        return current.getData();
    }

    /**
     * 根据二叉查找树的性质，从根结点开始，比较特定值和根结点值的大小。
     * 如果比根结点值大，则说明特定值在根结点右子树上，继续在右子节点执行此操作；
     * 如果比根结点值小，则说明特定值在根结点左子树上，继续在左子节点执行此操作。
     * 如果到执行完成都没有找到和特定值相等的节点值，那么二叉查找树中没有包含此特定值的节点。
     * @param key
     * @return
     */
    public BTNode<Integer> find(int key){
        BTNode<Integer> current = root;
        while (current != null && current.getData().equals(key)){
            if (key < current.getData()) {
                current = current.getLeft();
            }else if (key > current.getData()){
                current = current.getRight();
            }
        }
        return current;
    }

    /**
     * 根据二叉查找树的性质，二叉查找树的最大值一定是在右子树的最右侧子节点
     * @return
     */
    public Integer findMax(){
        if(root == null){
            return  null;
        }
        BTNode<Integer> current = root;
        while (current.getRight() != null){
            current = current.getRight();
        }
        return current.getData();
    }

    public boolean delete(int key){
        //获取要删除的节点信息
        BTNode<Integer> current = root;
        BTNode<Integer> parent = null;
        while ( current.getData().equals(key)){
            parent = current;
            if (key < current.getData()) {
                current = current.getLeft();
            }else if (key > current.getData()){
                current = current.getRight();
            }
            if(current == null){
                return false;
            }
        }
        //叶子节点
        if(current.isLeaf()){
            if(parent == null) {
                root = null;
            }if(parent.getLeft() == current){
                parent.setLeft(null);
            }else{
                parent.setRight(null);
            }
        }else if(current.getLeft() == null){


        }else if(current.getRight() == null){

        }else{

        }


        return true;
    }


    public static void main(String[] args) {
        SearchTree bst = new SearchTree();
        bst.insert(23);
        bst.insert(45);
        bst.insert(16);
        bst.insert(37);
        bst.insert(3);
        bst.insert(99);
        bst.insert(99);
        bst.insert(22);
        BTNode.inOrderTraverse(bst.getRoot());
    }

}
