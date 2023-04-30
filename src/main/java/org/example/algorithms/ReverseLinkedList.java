
package org.example.algorithms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ReverseLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList mySinglyLinkedList = new SinglyLinkedList(5);
        mySinglyLinkedList.append(8);
        mySinglyLinkedList.append(4);
        mySinglyLinkedList.prepend(10);
        mySinglyLinkedList.printList();
        mySinglyLinkedList.insert(2,15);
        mySinglyLinkedList.printList();
        mySinglyLinkedList.remove(100);
        mySinglyLinkedList.remove(2);
        mySinglyLinkedList.printList();

        mySinglyLinkedList.reverse();
        mySinglyLinkedList.printList();
    }

    public static class SinglyLinkedList {
        private Node head;
        private Node tail;
        private int length = 1;

        public SinglyLinkedList(int value) {
            head = new Node(value);
            tail = head;
        }

        public void prepend(int value) {
            head = new Node(value, head);
            length++;
        }

        public void append(int value) {
            Node newNode = new Node(value);
            tail.setNext(newNode);
            tail = newNode;
            length++;
        }

        public void printList() {
            if (head == null) {
                return;
            }
            Node currentNode = head;
            System.out.print(currentNode.getValue());
            currentNode = currentNode.getNext();
            while (currentNode != null) {
                System.out.print("-->" + currentNode.getValue());
                currentNode = currentNode.getNext();
            }
            System.out.println();
        }

        public void insert(int index, int value) {
            index = wrapIndex(index);
            if (index == 0) {
                prepend(value);
                return;
            }

            if (index == length - 1) {
                append(value);
                return;
            }

            Node leader = traverseToIndex(index - 1);
            Node nextNode = leader.getNext();

            Node newNode = new Node(value, nextNode);
            leader.setNext(newNode);
            length++;
        }

        public void remove(int index) {
            index = wrapIndex(index);
            if (index == 0) {
                head = head.getNext();
                return;
            }

            Node leader = traverseToIndex(index - 1);
            Node nodeToRemove = leader.getNext();
            leader.setNext(nodeToRemove.getNext());
            length--;
        }

        public void reverse() {
            Node first = head;
            tail = head;
            Node second = first.getNext();
            for (int i = 0; i < length - 1; i++) {
                Node temp = second.getNext();
                second.setNext(first);
                first = second;
                second = temp;
            }
            head.setNext(null);
            head = first;
        }

        public Node traverseToIndex(int index) {
            index = wrapIndex(index);
            Node currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            return currentNode;
        }

        private int wrapIndex(int index) { //Used for wrapping the given index to make sure it's valid
            return Math.max(Math.min(index, length - 1), 0);
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
