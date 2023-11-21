package Java.Interface;

import java.util.Arrays;

public class ArrayList<E> implements List<E>{
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};
    Object [] array;
    private int size;


    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size= 0;
    }

    public ArrayList(int capacity) {
        this.array = new Object[capacity];
        this.size =0;
    }

    private void resize() {
        int array_capacity = array.length;
        // array의 Capacity가 0이라면
        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        // 용량이 꽉 찰경우
        if (size == array_capacity) {
            int new_capacity = array_capacity * 2;

            //카피
            array = Arrays.copyOf(array, new_capacity);
            return;
        }

        // 용적의 절반 미만으로 요소가 차지할 경우
        if (size < (array_capacity / 2)) {
            int new_capacity = array_capacity / 2;
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, new_capacity));
            return;
        }
    }

    @Override
    public boolean add(final E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value) {
        if (size == array.length) {
            resize();
        }
        array[size] = value;
        size++;
    }

    @Override
    public void add(final int index, final E value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            addLast(value);
        }
        else{
            if (size == array.length) {
                resize();
            }
            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            size++;
        }

    }

    public void addFirst(E value) {
        add(0, value);
    }

    @Override
    public void remove(final int index) {

    }

    @Override
    public boolean remove(final Object value) {
        return false;
    }

    @Override
    public E get(final int index) {
        return null;
    }

    @Override
    public boolean contains(final Object value) {
        return false;
    }

    @Override
    public int indexOf(final Object value) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}
