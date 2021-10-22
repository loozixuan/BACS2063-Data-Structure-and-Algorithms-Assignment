/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.util.Comparator;

/**
 *
 * @author Chow Sing Hong
 */
public class ChowSHComparableLinkedList<T extends Comparable<T>> implements ChowSHListInterface<T> {

    Node firstNode;
    Node lastNode;
    int numberOfElements;

    @Override
    public boolean add(T newElement) {
        Node newNode = new Node(newElement);
        if (numberOfElements == 0) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
        numberOfElements++;
        return true;
    }

    @Override
    public boolean add(int position, T newElement) {
        Node newNode = new Node(newElement);
        if (position == 1) {
            if (numberOfElements == 0) {
                firstNode = newNode;
                lastNode = newNode;
            } else {
                newNode.next = firstNode;
                firstNode = newNode;
            }
            numberOfElements++;
            return true;
        } else if (position > 1 && position <= numberOfElements) {
            Node previousNode = firstNode;
            for (int i = 1; i < position - 1; i++) {
                previousNode = previousNode.next;
            }
            newNode.next = previousNode.next;
            previousNode.next = newNode;
            numberOfElements++;
            return true;
        } else {
            add(newElement);
            return true;
        }
    }

    @Override
    public T remove(int position) {
        if (position == 1) {
            if (numberOfElements >= 1) {
                T result = firstNode.data;
                firstNode = firstNode.next;
                numberOfElements--;
                return result;
            } else {
                return null;
            }
        } else if (position > 1 && position <= numberOfElements) {
            Node previousNode = firstNode;
            for (int i = 1; i < position - 1; i++) {
                previousNode = previousNode.next;
            }
            T result = previousNode.next.data;
            previousNode.next = previousNode.next.next;
            if (position == numberOfElements) {
                lastNode = previousNode;
            }
            numberOfElements--;
            return result;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(T element) {
        boolean found = false;
        Node currentNode = firstNode;
        Node previousNode = null;
        for (int i = 1; i <= numberOfElements; i++) {
            if (element.compareTo(currentNode.data) == 0) {
                if (i == 1) {
                    firstNode = firstNode.next;
                } else if (i > 1 && i < numberOfElements) {
                    previousNode.next = currentNode.next;
                } else {
                    lastNode = previousNode;
                }
                numberOfElements--;
                return true;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    @Override
    public int clear() {
        firstNode = null;
        int result = numberOfElements;
        numberOfElements = 0;
        return result;
    }

    @Override
    public T get(int position) {
        T element;
        if (position < 1 || position > numberOfElements) {
            element = null;
        } else if (position == 1) {
            element = firstNode.data;
        } else if (position == numberOfElements) {
            element = lastNode.data;
        } else {
            Node currentNode = firstNode;
            for (int i = 1; i < position; i++) {
                currentNode = currentNode.next;
            }
            element = currentNode.data;
        }
        return element;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public T contains(T element) {
        Node curreNode = firstNode;
        for (int i = 1; i <= numberOfElements; i++) {
            if (element.compareTo(curreNode.data) == 0) {
                return curreNode.data;
            }
            curreNode = curreNode.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public ChowSHComparableLinkedList getSortedList() {
        ChowSHComparableLinkedList<T> ascendingSortedList = new ChowSHComparableLinkedList<T>();
        if (!isEmpty()) {
            ascendingSortedList.firstNode = new Node(this.firstNode.data);
            ascendingSortedList.lastNode = ascendingSortedList.firstNode;
            ascendingSortedList.numberOfElements++;
            Node currentNode = this.firstNode.next;
            for (int i = 2; i <= this.numberOfElements; i++) {
                Node newNode = new Node(currentNode.data);
                if (newNode.data.compareTo(ascendingSortedList.firstNode.data) <= 0) {
                    newNode.next = ascendingSortedList.firstNode;
                    ascendingSortedList.firstNode = newNode;
                } else if (newNode.data.compareTo(ascendingSortedList.lastNode.data) > 0) {
                    ascendingSortedList.lastNode.next = newNode;
                    ascendingSortedList.lastNode = newNode;
                } else {
                    Node currentNode2 = ascendingSortedList.firstNode;
                    boolean found = false;
                    for (int j = 1; j <= ascendingSortedList.numberOfElements - 1 && !found; j++) {
                        if (newNode.data.compareTo(currentNode2.data) <= 0) {
                            newNode.next = currentNode2.next;
                            currentNode2.next = newNode;
                            found = true;
                        }
                    }
                }
                ascendingSortedList.numberOfElements++;
                currentNode = currentNode.next;
            }
            return ascendingSortedList;
        } else {
            return null;
        }
    }

    @Override
    public ChowSHComparableLinkedList getSortedList(Comparator comparator) {
        ChowSHComparableLinkedList<T> ascendingSortedList = new ChowSHComparableLinkedList<T>();
        if (!isEmpty()) {
            ascendingSortedList.firstNode = new Node(this.firstNode.data);
            ascendingSortedList.lastNode = ascendingSortedList.firstNode;
            ascendingSortedList.numberOfElements++;
            Node currentNode = this.firstNode.next;
            for (int i = 2; i <= this.numberOfElements; i++) {
                Node newNode = new Node(currentNode.data);
                if (comparator.compare(newNode.data, ascendingSortedList.firstNode.data) <= 0) {
                    newNode.next = ascendingSortedList.firstNode;
                    ascendingSortedList.firstNode = newNode;
                } else if (comparator.compare(newNode.data, ascendingSortedList.firstNode.data) > 0) {
                    ascendingSortedList.lastNode.next = newNode;
                    ascendingSortedList.lastNode = newNode;
                } else {
                    Node currentNode2 = ascendingSortedList.firstNode;
                    boolean found = false;
                    for (int j = 1; j <= ascendingSortedList.numberOfElements - 1 && !found; j++) {
                        if (comparator.compare(newNode.data, ascendingSortedList.firstNode.data) <= 0) {
                            newNode.next = currentNode2.next;
                            currentNode2.next = newNode;
                            found = true;
                        }
                    }
                }
                ascendingSortedList.numberOfElements++;
                currentNode = currentNode.next;
            }
            return ascendingSortedList;
        } else {
            return null;
        }
    }

    @Override
    public boolean merge(ChowSHListInterface<T> list) {
        ChowSHComparableLinkedList<T> anotherList = (ChowSHComparableLinkedList<T>) list;
        if (anotherList.size() <= 0) {
            return false;
        } else {
            if (numberOfElements == 0) {
                firstNode = anotherList.firstNode;
                lastNode = anotherList.lastNode;
            } else {
                lastNode.next = anotherList.firstNode;
                lastNode = anotherList.lastNode;
            }
            numberOfElements += anotherList.numberOfElements;
            return true;
        }
    }

    @Override
    public String toString() {
        String result = "";
        Node currentNode = firstNode;
        for (int i = 1; i <= numberOfElements; i++) {
            result += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        return result;
    }

    private class Node {

        private T data;
        private Node next;

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
