package com.solvd.agency.utils;

public class Node<T> {
    private T data; //Data in the current node
    private Node<T> next; //Reference for the next node

    //Constructor which takes an int value which is stored as the data in this Node object.
    Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}