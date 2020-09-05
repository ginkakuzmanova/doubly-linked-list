package abstraction;

public interface List<T> {
    public void insert(int index, T value) throws
            IndexOutOfBoundsException;

    public void delete(int index) throws IndexOutOfBoundsException;

    public T get(int index) throws IndexOutOfBoundsException;

    public int size();

    public void set(int index, T value) throws
            IndexOutOfBoundsException;

    public boolean delete(T value);

    public boolean contains(T value);

    public int indexOf(Object value);

    public boolean isEmpty();

    public void clear();
}
