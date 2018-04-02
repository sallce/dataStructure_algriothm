package com.dataStructure_algriothm.linkedlist;

public class MyLinkedList {
    Node head;

    // LinkedList node
    class Node {
        int data;
        Node next;
        public Node(int d) {
            data = d;
            next = null;
        }
    }

    // Insert a new Node at front of the list
    public void push(int new_data) {
        // 1 & 2: Allocate the Node & Put in the data
        Node new_node = new Node(new_data);

        // 3. Make next of new Node as head
        new_node.next = head;

        // 4. Move the head to point to new Node
        head = new_node;
    }


    // Insert a new node after the given prev_node
    public void insertAfter(Node prev_node, int new_data) {
        // 1. Check if the given Node is null
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

        // 2 & 3: Allocate the Node & Put in the data
        Node new_node = new Node(new_data);

        // 4. Make next of new Node as next of prev_node
        new_node.next = prev_node.next;

        // 5. Make next of prev node as new_node
        prev_node.next = new_node;
    }


    /* Appends a new node at the end. This method is
        defined inside LinkedList class shown above */
    public void append(int new_data) {
        /* 1. Allocate the Node
           2. Put in the data
           3. Set next as null */
        Node new_node = new Node(new_data);

        /* 4. If the Linked List is empty, then make the
              new node as head */
        if (head == null) {
            head = new_node;
            return;
        }

        new_node.next = null;

        Node last = head;
        while(last.next != null) {
            last = last.next;
        }

        last.next = new_node;
        return;

    }


    public void deleteNode(int key) {
        Node temp = head, prev = null;

        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        while(temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        prev.next = temp.next;

    }


    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.println(tnode.data+" ");
            tnode = tnode.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList llist = new MyLinkedList();

        llist.append(6);
        llist.push(7);
        llist.push(1);
        llist.append(4);

        llist.insertAfter(llist.head.next, 8);

        System.out.println("\nCreated Linked list is: ");

        llist.printList();

        System.out.println("\nLinked List after Deleting key value 4: ");
        llist.deleteNode(4);

        llist.printList();
    }



}
