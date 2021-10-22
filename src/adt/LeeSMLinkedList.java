/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Chrisann Lee
 */
public class LeeSMLinkedList<T extends Comparable<T>> implements LeeSMListInterface<T> {

    private Node firstNode;
    private Node lastNode;
    private int numberOfEntries;

    public LeeSMLinkedList() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }

        lastNode = newNode;
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean edit(T anEntry, int givenPosition) {

        boolean valid = false;
        if (!isEmpty() || givenPosition >= 1 && givenPosition <= numberOfEntries) {
            if (givenPosition == numberOfEntries) {
                lastNode.data = anEntry;
                valid = true;
            } else {
                Node findNode = firstNode;
                for (int index = 1; index < givenPosition; index++) {
                    findNode = findNode.next;
                }
                findNode.data = anEntry;
                valid = true;
            }
        }
        return valid;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;
        if (!isEmpty() || givenPosition >= 1 && givenPosition <= numberOfEntries) {

            if (givenPosition == 1 && numberOfEntries == 1) {
                result = firstNode.data;
                firstNode = null;
                lastNode = null;

            } else if (givenPosition == 1 && numberOfEntries > 1) {
                result = firstNode.data;
                firstNode = firstNode.next;

            } else if (givenPosition == numberOfEntries) {

                result = lastNode.data;
                Node tempNode = firstNode;
                for (int index = 1; index < givenPosition - 1; index++) {
                    tempNode = tempNode.next; //get previous data
                }

                lastNode = tempNode;

            } else {
                Node tempNode = firstNode;
                for (int index = 1; index < givenPosition - 1; index++) {
                    tempNode = tempNode.next;
                }

                result = tempNode.next.data;
                tempNode.next = tempNode.next.next;

            }
            numberOfEntries--;
        }

        return result;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        if (!isEmpty() || givenPosition >= 1 && givenPosition <= numberOfEntries) {
            if (givenPosition == numberOfEntries) {
                result = lastNode.data;
            } else {
                Node findNode = firstNode;

                int counter = 1;
                while (counter < givenPosition) {   //if want to find first node , it won't run
                    findNode = findNode.next;
                    counter++;
                }

                result = findNode.data;
            }
        }

        return result;
    }

    @Override
    public int getPosition(T anEntry) {
        int position = 0;
        if (!isEmpty()) {
            Node findNode = firstNode;
            for (int index = 0; index < numberOfEntries; index++) {
                if (anEntry.compareTo(findNode.data) == 0) {
                    position = index + 1;
                }
                findNode = findNode.next;
            }
        }
        return position;
    }

    @Override
    public T search(T anEntry) {
        T result = null;
        if (!isEmpty()) {
            Node findNode = firstNode;
            for (int index = 0; index < numberOfEntries; index++) {
                if (anEntry.compareTo(findNode.data) == 0) {
                    result = findNode.data;
                }
                findNode = findNode.next;
            }
        }

        return result;
    }

    public void selectionSortDesc() {
        for (Node node1 = firstNode; node1 != null; node1 = node1.next) {

            Node greater = node1;//firstNode be the greatest node

            //find greater node
            for (Node node2 = node1; node2 != null; node2 = node2.next) {
                if (greater.data.compareTo(node2.data) < 0) {
                    greater = node2;
                }

            }
//swaps the greater node with the node in its actual position
            Node temp = new Node(node1.data);
            node1.data = greater.data;
            greater.data = temp.data;
        }
    }

    public final void clear() {
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    private class Node {

        private T data;
        private Node next;
        private Node previous;

        private Node() {

        }

        private Node(T data) {
            this.data = data;
            next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
