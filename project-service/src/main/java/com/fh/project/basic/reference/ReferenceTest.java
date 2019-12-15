package com.fh.project.basic.reference;

public class ReferenceTest<T> {

    public Node mergeTwoSortedLinkedList() {
        Node head = null;
        Node temp = new Node(1);
        // 传递失败
        insert(head, temp);
        return head;

    }

    private Node insert(Node head, Node node) {
        if (head == null) {
            head = node;
        } else {
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;

        }
        return head;
    }

    class Node<T> {

        public T element;

        public Node next;

        public Node(T element) {
            this.element = element;
        }
    }

    public static void main(String[] args) {
        ReferenceTest example = new ReferenceTest();
        example.mergeTwoSortedLinkedList();
    }

}

