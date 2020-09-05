package implementation;

import abstraction.Deque;
import abstraction.List;

public class LinkedList<E> implements List<E>, Deque<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> previous;
        private Node<E> next;

        public Node(E value) {
            this.element = value;
        }
    }

    public LinkedList() {
    }


    public void addFirst(E var1) {

    }

    public void addLast(E var1) {

    }

    public boolean offerFirst(E var1) {
        return false;
    }

    public boolean offerLast(E var1) {
        return false;
    }

    public E removeFirst() {
        return null;
    }

    public E removeLast() {
        return null;
    }

    public E pollFirst() {
        return null;
    }

    public E pollLast() {
        return null;
    }

    public E getFirst() {
        return null;
    }

    public E getLast() {
        return null;
    }

    public void add(E value) {

    }

    public boolean offer(E var1) {
        return false;
    }

    public E remove() {
        return null;
    }

    public E poll() {
        return null;
    }

    public E element() {
        return null;
    }

    public E peek() {
        return null;
    }

    public void insert(int index, E value) throws IndexOutOfBoundsException {

    }

    public void delete(int index) throws IndexOutOfBoundsException {

    }

    public E get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    public int size() {
        return 0;
    }

    public void set(int index, E value) throws IndexOutOfBoundsException {

    }

    public boolean delete(E value) {
        return false;
    }

    public boolean contains(E value) {
        return false;
    }

    public int indexOf(Object value) {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public void clear() {

    }
}
