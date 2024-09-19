package by.mariayuran.homework.containers;

import java.util.Iterator;


public class MyHashSet<T> implements Iterable<T> {
    private static final int INITIAL_CAPACITY = 16;
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        if (!contains(element)) {
            if (size == data.length) {
                resize();
            }
            int index = getIndex(element);
            data[index] = element;
            size++;
        }
    }



    public void remove(T element) {
        int index = getIndex(element);
        if (data[index] != null && data[index].equals(element)) {
            data[index] = null;
            size--;
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new CustomHashSetIterator();
    }


    private int getIndex(T element) {
        return Math.abs(element.hashCode() % data.length);
    }

    private boolean contains(T element) {
        int index = getIndex(element);
        return data[index] != null && data[index].equals(element);
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newData = (T[]) new Object[data.length * 2];
        for (T element : data) {
            if (element != null) {
                int index = getIndex(element);
                while (newData[index] != null) {
                    index = (index + 1) % newData.length;
                }
                newData[index] = element;
            }
        }
        data = newData;
    }

    private class CustomHashSetIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            while (currentIndex < data.length && data[currentIndex] == null) {
                currentIndex++;
            }
            return currentIndex < data.length;
        }

        @Override
        public T next() {
            while (currentIndex < data.length && data[currentIndex] == null) {
                currentIndex++;
            }
            return data[currentIndex++];
        }
    }
}
