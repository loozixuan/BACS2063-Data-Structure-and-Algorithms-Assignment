package adt;

public interface WongZJArraylistInterface<T> {

    public boolean add(T newElement);

    public boolean add(int newPosition, T newElement);

    public T remove(int givenPosition);

    public int size();

    public void clear();

    public T getEntry(int givenPosition);

    public int getNumberOfEntries();

    public boolean isEmpty();

    public boolean isFull();
}
