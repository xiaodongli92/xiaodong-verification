package com.xiaodong.verification.model;

/**
 * @Description:
 * @Author: lixiaodong@souyidai.com
 * @CreateDate: 2016/9/26
 */
public class TreeNode<E> {
    
    public TreeNode(E e) {
        this.data = e;
    }

    private E data;

    private TreeNode<E> left;

    private TreeNode<E> right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }
}
