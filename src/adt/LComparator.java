package adt;

/**
 *
 * @author Loo Zi Xuan
 */
@FunctionalInterface
public interface LComparator<T> {

    /*
     * Description  : Compares the first object with the second object
     * Return       :     1 = First object is larger than second
     *                    0 = Both object are equal
     *                   -1 = First object is smaller than second
     */
    int compare(T object1, T object2);
}
