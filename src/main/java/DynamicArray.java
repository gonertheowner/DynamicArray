import javax.management.ObjectName;
import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T>{
    private T[] array;
    private int size;
    private int capacity;

    public DynamicArray() {
        this(10);
    }

    public DynamicArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        } else {
            capacity = initialCapacity;
            array = (T[]) new Object[capacity];
        }
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return array[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        if (size + 1 > capacity) {
            capacity*= 2;
            T[] newArray = (T[]) new Object[capacity];
            if (size >= 0) System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size++] = element;
    }

    public void clear() {
        Arrays.fill(array, null);
        size = 0;
        capacity = 10;
    }

    public T removeAt(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            T data = array[index];
            T[] newArray = (T[]) new Object[size - 1];

            for (int i = 0, j = 0; i < size; i++, j++) {
                if (i == index) {
                    j--;
                } else {
                    newArray[j] = array[i];
                }
            }
            array = newArray;
            capacity = --size;
            return data;
        }
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(obj)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;
            public boolean hasNext() { return index < size; }
            public T next() { return  array[index++]; }
        };
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder(size).append("[");
            for (int i = 0; i < size - 1; i++) {
                sb.append(array[i]).append(", ");
            }
            return sb.append(array[size - 1]).append("]").toString();
        }
    }
}
