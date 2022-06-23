package module_2.no10_list.exercise.e1;

import java.util.Arrays;

public class MyList<E> implements Cloneable {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int Capacity) {
        elements = new Object[Capacity];
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
        return true;
    }

    public void add(int index, E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        int length = elements.length;
        Object[] newArr = new Object[length];
        newArr[index] = e;
        for (int i = 0; i < index; i++) {
            newArr[i] = elements[i];
        }
        for (int i = index + 1; i < length; i++) {
            newArr[i] = elements[i - 1];
        }
        elements = Arrays.copyOf(newArr, length);
        size++;
    }

    public void remove(int index) {
        int length = elements.length;
        Object[] newArr = new Object[length];
        for (int i = 0; i < index; i++) {
            newArr[i] = elements[i];
        }
        for (int i = index; i < length - 1; i++) {
            newArr[i] = elements[i + 1];
        }
        elements = Arrays.copyOf(newArr, length);
        size--;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public int size() {
        return size;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == e)
                return true;
        }
        return false;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == e)
                return i;
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public MyList<E> clone() {
        MyList<E> v = new MyList<>();
        v.elements = Arrays.copyOf(elements, size);
        v.size = size;
        return v;
    }

    @Override
    public String toString() {
        elements = Arrays.copyOf(elements, size);
        return Arrays.toString(elements);
    }
}
