package adt;

/**
 *
 * @author Loo Zi Xuan
 */
public interface LooZXListInterface<T> {

    public boolean add(T newElement);

    public boolean add(int newIndex, T newElement);

    public T remove(int removedIndex);

    public boolean remove(T element);

    public T setEntry(int index, T element);

    public T getEntry(int index);

    public boolean contains(T element);

    public int getNumberOfEntries();

    @SuppressWarnings("unchecked")
    public void trimToSize();

    public int size();

    public void clear();

    public boolean isEmpty();

    public boolean isFull();

    public Object[] toArray();

    public void sort(Object[] a, LComparator c);
}
