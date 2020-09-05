package abstraction;

public interface Deque<E> extends Queue<E> {
    void addFirst(E var1);

    void addLast(E var1);

    boolean offerFirst(E var1);

    boolean offerLast(E var1);

    E removeFirst();

    E removeLast();

    E pollFirst();

    E pollLast();

    E getFirst();

    E getLast();
}
