package ab1.impl.Nachnamen;

import ab1.SortedList;

public class SortedListImpl implements SortedList {
    private Node head;
    private int length;

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public SortedListImpl() {
        head = null;
        length = 0;
    }

    @Override
    public void clear() {
        head = null;
        length = 0;
    }

    @Override
    public void insert(int key) throws IllegalArgumentException {
        if (contains(key)) {
            throw new IllegalArgumentException("Duplicate key: " + key);
        }

        Node newNode = new Node(key);
        if (head == null || key < head.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && key >= current.next.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        length++;
    }

    @Override
    public boolean remove(int key) {
        if (head == null)
            return false;

        if (head.data == key) {
            head = head.next;
            length--;
            return true;
        }

        Node current = head;
        Node previous = null;
        while (current != null && current.data != key) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
            length--;
            return true;
        }

        return false;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[length];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    private boolean contains(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key)
                return true;
            current = current.next;
        }
        return false;
    }
}
