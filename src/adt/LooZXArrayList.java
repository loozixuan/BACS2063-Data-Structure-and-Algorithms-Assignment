package adt;

/**
 *
 * @author Loo Zi Xuan
 */
public class LooZXArrayList<T> implements LooZXListInterface<T> {

    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 15;

    public LooZXArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public LooZXArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        numberOfEntries = 0;
        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(T newElement) {
        if (!isFull()) {
            array[size()] = newElement;
        } else {
            resize();
            array[size()] = newElement;
        }
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean add(int newIndex, T newElement) {
        if (newIndex >= 0 || newIndex < size()) {
            if (isFull()) {
                resize();
            }
            //Move each element to the right & increase the numberOfEntries by 1.
            for (int i = size() - 1; i >= newIndex - 1; i--) {
                array[i + 1] = array[i];
            }
            array[newIndex - 1] = newElement;
            numberOfEntries++;
        } else {
            return false;
        }
        return true;
    }

    @Override
    public T remove(int removedIndex) {
        T removedElement = null;

        if (removedIndex > 0 && removedIndex <= numberOfEntries) {
            removedElement = array[removedIndex - 1];

            if (removedIndex < numberOfEntries) {
                fastRemove(removedIndex - 1);
            }
        }

        return removedElement;
    }

    @Override
    public boolean remove(T removedElement) {
        if (removedElement == null) { //if such a null element exists
            for (int removedIndex = 0; removedIndex < numberOfEntries; removedIndex++) {
                if (array[removedIndex] == null) {
                    fastRemove(removedIndex);
                    return true;
                }
            }
        } else {
            for (int removedIndex = 0; removedIndex < numberOfEntries; removedIndex++) {
                if (removedElement.equals(array[removedIndex])) {
                    fastRemove(removedIndex);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public T setEntry(int index, T element) {
        if (index > 0 && index <= size()) {
            array[index - 1] = element;
            return array[index - 1];
        } else {
            return null;
        }
    }

    @Override
    public T getEntry(int index) {
        if (index > 0 && index <= size()) {
            return array[index - 1];
        } else {
            return null;
        }
    }

    @Override
    public boolean contains(T element) {
        if (element != null) {
            for (Object o : array) {
                if (o != null && o.equals(element)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void trimToSize() {
        int oldCapacity = array.length;
        T[] trimArray = (T[]) new Object[numberOfEntries];

        if (numberOfEntries < oldCapacity) {
            for (int i = 0; i < numberOfEntries; i++) {
                trimArray[i] = this.array[i];
            }
        }
        array = trimArray;
    }

    @Override
    public int size() {
        return this.numberOfEntries;
    }

    @Override
    public void clear() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        numberOfEntries = 0;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean isFull() {
        return size() == array.length;
    }

    @Override
    public Object[] toArray() {
        Object[] toArray = new Object[numberOfEntries];
        for (int i = 0; i < this.size(); i++) {
            toArray[i] = this.array[i];
        }
        return toArray;
    }

    @Override
    public void sort(Object[] array, LComparator comparator) {
        this.mergeSort(array, 0, array.length - 1, comparator);
    }

    @Override
    public String toString() {
        StringBuilder outputStr = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            outputStr.append(array[i]);
            outputStr.append('\n');
        }
        return outputStr.toString();
    }

    public static String toString(Object[] object) {
        StringBuilder outputStr = new StringBuilder();
        for (Object otherObject : object) {
            outputStr.append(otherObject.toString());
            outputStr.append('\n');
        }
        return outputStr.toString();
    }

    private void resize() {
        T[] resizedArray = (T[]) new Object[array.length * 2];
        for (int i = 0; i < this.size(); i++) {
            resizedArray[i] = this.array[i];
        }

        array = resizedArray;
    }

    private void fastRemove(int index) {
        for (int i = index; i < numberOfEntries; i++) {
            array[i] = array[i + 1];
        }
        array[numberOfEntries--] = null;
    }

    public void mergeSort(Object[] array, int start, int end, LComparator comparator) {
        if (start < end) { // base case
            int middle = (start + end) / 2;

            mergeSort(array, start, middle, comparator); // sort first half
            mergeSort(array, middle + 1, end, comparator); // sort second half
            merge(array, start, middle, end, comparator); // merge the sorted halves
        }
    }

    private void merge(Object[] array, int start, int middle, int end, LComparator c) {
        // Subarray1 = a[start..middle]
        // Subarray2 = a[middle+1..end]
        int n = end - start + 1;
        Object[] temp = new Object[n];
        int leftIndex = start;
        int rightIndex = middle + 1;
        int beforeIndex = 0;

        while (leftIndex <= middle && rightIndex <= end) // the merging
        {
            if (c.compare(array[leftIndex], array[rightIndex]) < 0) {
                temp[beforeIndex] = array[leftIndex];
                leftIndex++;
            } else {
                temp[beforeIndex] = array[rightIndex];
                rightIndex++;
            }
            beforeIndex++;
        }

        while (leftIndex <= middle) { // copy remaining elements (if any)
            temp[beforeIndex] = array[leftIndex];
            beforeIndex++;
            leftIndex++;
        }

        while (rightIndex <= end) { // copy remaining elements (if any)
            temp[beforeIndex] = array[rightIndex];
            beforeIndex++;
            rightIndex++;
        }

        for (int index = 0; index < n; index++) {
            array[start + index] = temp[index];
        }
    }

}
