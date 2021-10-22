/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Chrisann Lee
 */
public interface ChrisListInterface<T extends Comparable<T>> {

    public boolean add(T newEntry);

    public boolean edit(T anEntry, int position);

    public T remove(int position);

    public T getEntry(int position);

    public int getPosition(T anEntry);

    public T search(T anEntry);

    public void selectionSort();

    public void clear();

    public boolean isEmpty();

    public int getNumberOfEntries();

}
