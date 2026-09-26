package com.practice;

public class DoubleLinkedList {

    DoubleNode head;
    DoubleNode tail;

    public  DoubleLinkedList (){
    }

    public void addNode(DoubleNode node){
        if(head == null){
            head = node;
        }else{
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
    }

    public void remove(DoubleNode node) {
        DoubleNode prevNode = null;
        DoubleNode nextNode = null;

        if (node == head) {
            if(head.next != null) {
                head = head.next;
                head.prev = null;
            }else{
                head = null;
                tail = null;
            }
        } else if (node == tail) {
            if(tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            }else{
                head = null;
                tail = null;
            }
        } else {
            prevNode = node.prev;
            nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }

    public void reverse(){
        DoubleNode temp = null;
        DoubleNode current = head;
        DoubleNode newHead = tail;
        DoubleNode newTail = head;



        while(current != null){
            temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        }

        head = newHead;
        tail = newTail;
    }


    }


class DoubleNode {
    DoubleNode next;
    DoubleNode prev;
    int val;
}