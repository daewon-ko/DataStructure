package Java.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E>{

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
    public E push(final E item) {
        if (size == array.length) {
            resize();
        }
        array[size] = item;
        size++;
        return item;
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }


        E obj = (E) array[size - 1];

        array[size - 1] = null;
        size--;
        resize();

        return obj;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (E)array[size - 1];
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
