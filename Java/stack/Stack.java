package Java.stack;

import java.util.Arrays;

public class Stack<E> implements StackInterface {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};

    private Object[] array;
    private int size;

    public Stack() {
        this.array = EMPTY_ARRAY;
        size = 0;
    }

    public Stack(final int size) {
        this.array = new Object[size];
        this.size = 0;
    }

    private void resize() {

        if (Arrays.equals(array, EMPTY_ARRAY)) {
            this.array = new Object[DEFAULT_CAPACITY];
            return;
        }
        int arrayCapacity = array.length;

        if (size == arrayCapacity) {
            int newArrayCapacity = size * 2;
            array = Arrays.copyOf(array, newArrayCapacity);
            return;
        }
        if (size < (arrayCapacity / 2)) {
            int newCapacity = arrayCapacity / 2;
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
            return;
        }
    }

    @Override
    public Object push(final Object item) {
        return null;
    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public int search(final Object value) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean empty() {
        return false;
    }
}
