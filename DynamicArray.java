import java.util.Arrays;


public class DynamicArray<T> {
    private Object[] array;
    private int size;
    private int capacity;

    public DynamicArray() {
        size = 0;
        capacity = 2;
        array = new Object[2];
    }

    public void ensureCapacity(int minCapacity) {
        Object[] temp = new Object[minCapacity * capacity];
        for (int i = 0; i < capacity; i++) {
            temp[i] = (int) array[i];
        }
        array = temp;
        capacity = capacity * minCapacity;
    }

    public void trimToSize() {
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = (int) array[i];
        }
        array = temp;
        capacity = array.length;
    }

    public void add(int index, T el) {
        System.arraycopy(el, index,
                el, index + 1,
                size - index);
        size++;

    }

    public T get(int index) {
        return (T) array[index];
    }

    public void remove(Object[] es, int index) {
        final int newSize;
        if ((newSize = size - 1) > index)
            System.arraycopy(es, index + 1, es, index, newSize - index);
        es[size = newSize] = null;
    }

    public int size() {
        return size;
    }


    public int capacity() {
        return capacity;
    }

    
    public void printElements() {
        System.out.println("elements in array are :" + Arrays.toString(array));
    }
}