package abstraction;

public interface Queue<E> {
    boolean offer(E var1);

    E remove();

    E poll();

    E element();

    E peek();
}
