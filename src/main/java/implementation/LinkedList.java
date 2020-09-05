package implementation;

import abstraction.Deque;
import abstraction.List;

public class LinkedList<E> implements List<E>, Deque<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        private final E element;
        private Node<E> previous;
        private Node<E> next;

        public Node(E value) {
            this.element = value;
        }
    }

    public LinkedList() {
    }


    public void addFirst(E var1) {
        Node<E> nodeToAdd = new Node<>(var1);
        if (this.head != null) {
            nodeToAdd.next = this.head;
            this.head.previous = nodeToAdd;
            this.head = nodeToAdd;
        }
        this.head = this.tail = nodeToAdd;
        this.size++;
    }

    public void addLast(E var1) {
        if (this.size() == 0) {
            this.addFirst(var1);
        } else {
            Node<E> nodeToAdd = new Node<>(var1);
            this.tail.next = nodeToAdd;
            nodeToAdd.previous = this.tail;
            this.tail = nodeToAdd;
            this.size++;
        }
    }

    public boolean offerFirst(E var1) {
        return false;
    }

    public boolean offerLast(E var1) {
        return false;
    }

    public E removeFirst() {
        ensureNonEmpty();
        E element = this.head.element;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            Node<E> newHead = this.head.next;
            newHead.previous = null;
            this.head.next = null;
            this.head = newHead;
        }
        this.size--;
        return element;
    }

    public E removeLast() {
        ensureNonEmpty();
        if (this.size == 1) {
            return removeFirst();
        }
        E element = this.tail.element;
        Node<E> currentTail = this.tail;
        this.tail = currentTail.previous;
        this.tail.next = null;
        this.size--;

        return element;
    }

    public E pollFirst() {
        return null;
    }

    public E pollLast() {
        return null;
    }

    public E getFirst() {
        ensureNonEmpty();
        return this.head.element;
    }

    public E getLast() {
        ensureNonEmpty();
        return this.tail.element;
    }

    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public boolean offer(E var1) {
        //addLast
        Node<E> nodeToOffer = new Node<>(var1);
        if (this.head == null) {
            this.head = this.tail = nodeToOffer;
        } else {
            this.tail.next = nodeToOffer;
            this.tail = nodeToOffer;
        }
        this.size++;
        return true;
    }

    public E remove() {
        return removeLast();
    }

    public E poll() {
        ensureNonEmpty();
        E element = this.head.element;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node<E> next = this.head.next;
            this.head.next = null;
            this.head = next;
        }
        this.size--;
        return element;
    }

    public E element() {
        return getFirst();
    }

    public E peek() {
        ensureNonEmpty();
        return this.head.element;
    }

    public void insert(int index, E value) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(value);
        } else if (index == this.size) {
            addLast(value);
        } else {
            Node<E> node = new Node<>(value);
            E preNode = get(index - 1);
            Node<E> prev = new Node<>(preNode);
            Node<E> nextNode = prev.next;
            node.next = nextNode;
            node.previous = prev;
            nextNode.previous = node;
            prev.next = node;
            size++;
        }
    }

    public void delete(int index) throws IndexOutOfBoundsException {

    }

    public E get(int index) throws IndexOutOfBoundsException {
        ensureNonEmpty();
        if (0 >= index && index > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.element;
    }

    public int size() {
        return this.size;
    }

    public void set(int index, E value) throws IndexOutOfBoundsException {

    }

    public boolean delete(E value) {
        return false;
    }

    public boolean contains(E value) {
        Node<E> node = new Node<>(value);
        return indexOf(node) >= 0;
    }

    public int indexOf(Object value) {
        return 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private void ensureNonEmpty() {
        if (this.size == 0) {
            throw new IllegalStateException("Illegal operation for empty LinkedList");
        }
    }
}
