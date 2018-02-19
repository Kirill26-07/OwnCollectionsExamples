package com.kirill.collectionTypes;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ArrayCollection<T> implements Collection<T>{


    private T[] array = (T[]) new Object[2];
    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        for(int i = 0; i < size; i++){
            if(array[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    @Override
    public Object[] toArray() {
        T[] newArray = (T[])new Object[this.size()];
        System.arraycopy(array, 0, newArray, 0, this.size());
        return newArray;
    }

    @Override
    public <T1> T1[] toArray(final T1[] a) {
        if (a.length >= this.size()) {
            System.arraycopy(array,0, a, 0, size());
            return a;
        } else {
            return (T1[])Arrays.copyOf(this.array, this.size(), a.getClass());
        }
    }

    @Override
    public boolean add(final T t) {
        if(array.length == size){
           final T[] oldArray = array;
            array = (T[]) new Object[this.size * 2];
            System.arraycopy(oldArray, 0, array, 0, oldArray.length);
        }
        array[size++] = t;
        return true;
    }

    @Override
    public boolean remove(final Object o) {
        for(int i = 0; i < size(); i++) {
            if (array[i].equals(o)) {
                if (i == this.size() - 1) {
                    size--;
                    return true;
                }
                System.arraycopy(array, i + 1, array, i , this.size() - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for(Object item : c){
            if(!this.contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        for(T item : c){
            add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for(Object item : c){
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        for (Object item : this){
            if(!c.contains(item)) this.remove(item);
        }
        return true;
    }

    @Override
    public void clear() {
        array = (T[]) new Object[2];
        size = 0;
    }


    // Overriding methods equals nad hashCode for correct fields comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayCollection)) return false;
        ArrayCollection<?> that = (ArrayCollection<?>) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    private class ArrayIterator implements Iterator<T> {

        private int ingex;

        @Override
        public boolean hasNext() {
            return ArrayCollection.this.size() > ingex;
        }

        @Override
        public T next() {
            return ArrayCollection.this.array[ingex++];
        }
    }

    public T[] getArray() {
        return array;
    }

}
