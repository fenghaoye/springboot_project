package com.fh.project.algo.tree;

public class BinarySearchTree {

    private Node tree;


    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node find(int data) {
        Node node = tree;
        while (node != null) {
            if (node.data > data) {
                node = node.left;
            } else if (node.data < data) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    public Node add(int data) {
        Node node = tree;
        while (node != null) {
            if (node.data > data) {
                node = node.left;
            } else if (node.data < data) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }
}
