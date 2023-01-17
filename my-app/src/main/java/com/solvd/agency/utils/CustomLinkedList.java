package com.solvd.agency.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLinkedList<T> {

    private Node<T> head;
    private int size;
    private static final Logger LOGGER = LogManager.getLogger(CustomLinkedList.class);



    //function to add an element to the list at the end if there are element already and at the start if no elements are there
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null) {
            head = newNode;
        }else {
            Node<T> n = head;
            while(n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(newNode);
            size++;
        }
    }

    //function to add an element at the start of the list
    public void insertAtStart(int data) {
        Node newNode = new Node<>(data);

        newNode.setNext(head);
        head = newNode;
        size++;
    }

    //function to add an element at a given index
    public void insertAt(int index, int data) {
        if(index == 0){
            insertAtStart(data);
        }else{
            Node newNode = new Node(data);

            Node currentNode = head;
            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
    }

    //function to delete an element at the given index
    public void deleteAt(int index) {
        if(index == 0) {
            head = head.getNext();
        }else{
            Node<T> currentNode = head;
            for(int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
        }
    }

    //function to show the list
    public String show() {
        Node<T> currentNode = head;
        StringBuilder data = new StringBuilder();
        if(currentNode == null){
            LOGGER.info("List is empty");
        }
        else {
            while(currentNode != null) {
                data.append(currentNode.getData()).append("\n ");
                currentNode = currentNode.getNext();
            }
        }
        return data.toString();
    }

    public int getSize(){
        return size;
    }


}
