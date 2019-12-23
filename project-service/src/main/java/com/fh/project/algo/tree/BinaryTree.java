package com.fh.project.algo.tree;

public class BinaryTree {

    public static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.num);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.num);
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.num);

    }

    class Node {
        int num;
        Node left;
        Node right;
    }

}


