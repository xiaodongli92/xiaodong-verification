package com.xiaodong.verification.model;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: lixiaodong@souyidai.com
 * @CreateDate: 2016/9/26
 */
public class BinaryTree<E> {

    private TreeNode<E> root = null;

    public BinaryTree(E e) {
        root = new TreeNode<>(e);
    }

    public BinaryTree(TreeNode<E> root) {
        this.root = root;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public void addLeft(@NotNull TreeNode<E> node, @NotNull TreeNode<E> leftNode) {
        node.setLeft(leftNode);
    }

    public void addRight(@NotNull TreeNode<E> node, @NotNull TreeNode<E> rightNode) {
        node.setRight(rightNode);
    }

    public void addLeft(@NotNull TreeNode<E> node, E e) {
        if (node.getLeft() == null) {
            TreeNode<E> leftNode = new TreeNode<>(e);
            node.setLeft(leftNode);
        }
        node.getLeft().setData(e);
    }

    public void addRight(@NotNull TreeNode<E> node, E e) {
        if (node.getRight() == null) {
            TreeNode<E> rightNode = new TreeNode<>(e);
            node.setRight(rightNode);
        }
        node.getRight().setData(e);
    }

    /**
     * 前序遍历 根，左子树，右子树
     * @param node 遍历节点
     * @return 遍历后的数据
     */
    public List<E> preOrder(TreeNode<E> node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<E> list = new ArrayList<>();
        list.add(node.getData());
        preOrder(node.getLeft(), list);
        preOrder(node.getRight(), list);
        return list;
    }

    private void preOrder(TreeNode<E> node, List<E> list) {
        if (node != null) {
            list.add(node.getData());
            preOrder(node.getLeft(), list);
            preOrder(node.getRight(), list);
        }
    }

    /**
     * 中序遍历 左子树，根，右子树
     * @param node 遍历节点
     * @return 遍历后的数据
     */
    public List<E> midOrder(TreeNode<E> node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<E> list = new ArrayList<>();
        midOrder(node.getLeft(), list);
        list.add(node.getData());
        midOrder(node.getRight(), list);
        return list;
    }

    private void midOrder(TreeNode<E> node, List<E> list) {
        if (node != null) {
            midOrder(node.getLeft(), list);
            list.add(node.getData());
            midOrder(node.getRight(), list);
        }
    }

    /**
     * 后序排序 左子树，右子树，根
     * @param node
     * @return
     */
    public List<E> afterOrder(TreeNode<E> node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<E> list = new ArrayList<>();
        afterOrder(node.getLeft(), list);
        afterOrder(node.getRight(), list);
        list.add(node.getData());
        return list;
    }

    private void afterOrder(TreeNode<E> node, List<E> list) {
        if (node != null) {
            afterOrder(node.getLeft(), list);
            afterOrder(node.getRight(), list);
            list.add(node.getData());
        }
    }
}
