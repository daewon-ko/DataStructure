package Java.Interface;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};
    Object[] array;
    private int size;


    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public ArrayList(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
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
        } else {
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
    public E remove(final int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        E element = (E) array[index];
        array[index] = null;

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
            array[i + 1] = null;
        }
        size--;
        resize();
        return element;
    }

    @Override
    public boolean remove(final Object value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(final int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    @Override
    public boolean contains(final Object value) {
        if (indexOf(value) >= 0) {
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(final Object value) {
        for (int count = 0; count < size; count++) {
            if (array[count].equals(value)) {
                return count;
            }
        }
        // 만족하는 값이 없을 경우 -1을 리턴한다.
        return -1;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;

    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(final int index, final E value) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
        return (E) array[index];

    }

    @Override
    public int lastIndexOf(final E value) {
        for (int count = size; count > 0; count--) {
            if (array[count].equals(value)) {
                return count;
            }
        }
        return -1;
    }

    @Override
    public void clear() {

        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        resize();

    }

}
