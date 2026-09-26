package com.practice;

class MyLinkedList {

    private Node head = null;
    private int size = 0;

    public MyLinkedList() {}

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        Node newHead = new Node();
        newHead.val = val;
        newHead.next = head;
        head = newHead;
        size++;
    }

    public void addAtTail(int val) {
        Node newTail = new Node();
        newTail.val = val;
        if (head == null) {
            head = newTail;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTail;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node newNode = new Node();
        newNode.val = val;
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }
        size--;
    }
}

class Node {
    int val;
    Node next;

}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */