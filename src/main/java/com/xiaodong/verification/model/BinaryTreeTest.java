package com.xiaodong.verification.model;

/**
 * @Description:
 * @Author: lixiaodong@souyidai.com
 * @CreateDate: 2016/9/26
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree<String> binaryTree = new BinaryTree<>("a");
        TreeNode<String> root = binaryTree.getRoot();
        TreeNode<String> b = new TreeNode<>("b");
        TreeNode<String> c = new TreeNode<>("c");
        TreeNode<String> d = new TreeNode<>("d");
        TreeNode<String> e = new TreeNode<>("e ");
        TreeNode<String> f = new TreeNode<>("f");
        TreeNode<String> g = new TreeNode<>("g");
        TreeNode<String> h = new TreeNode<>("h");
        binaryTree.addLeft(root, b);
        binaryTree.addLeft(b, c);
        binaryTree.addRight(b, d);
        binaryTree.addRight(root, e);
        binaryTree.addLeft(e, f);
        binaryTree.addRight(e, g);
        binaryTree.addLeft(c, h);
        System.out.println("root 前序 = " + binaryTree.preOrder(root));
        System.out.println("root 中序 = " + binaryTree.midOrder(root));
        System.out.println("root 后序 = " + binaryTree.afterOrder(root));
    }
}
