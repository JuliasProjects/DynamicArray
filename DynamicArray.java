import java.util.Arrays;

public static class DynamicArray<T> {

    private final int minLength = 10;
    private T[] data;
    private int length, last;

    public DynamicArray() {
        last = -1;
        length = minLength;
        data = (T[]) new Object[length];
    }

    public int getLength() {
        return last + 1;
    }

    public T get(int index) {
        if (index < 0 || index >= getLength())
            throw new IndexOutOfBoundsException("wrong index");

        return data[index];
    }

    public void set(int index, T value) {
        if (index < 0 || index >= getLength())
            throw new IndexOutOfBoundsException("wrong index");

        data[index] = value;
    }

    private void resize() {
        T[] temp = Arrays.copyOfRange(data, 0, getLength());
        length = (length * 3) / 2 + 1;
        data = (T[]) new Object[length];
        for (int i = 0; i < temp.length; i++)
            data[i] = temp[i];
    }

    private void trim() {
        if (last > -1)
            data = Arrays.copyOfRange(data, 0, getLength());
    }

    public void add(T value) {
        if (last == length - 1) {
            resize();
        }
        last++;
        data[last] = value;
    }


    public void delete(int index) {
        if (index < 0 || index >= getLength())
            throw new IndexOutOfBoundsException("wrong index");

        for (int i = index; i < last; i++) {
            data[i] = data[i + 1];
        }
        last--;

        if (Math.round(length / last) >= 2) {
            trim();
        }
    }


    public T[] toArray() {
        return (T[]) Arrays.copyOfRange(data, 0, getLength());
    }


}