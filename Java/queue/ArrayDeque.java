package Java.queue;

import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 64;
    private Object[] array;
    private int size;
    private int front;
    private int rear;

    public ArrayDeque() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public ArrayDeque(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    private void resize(int newCapacity) {
        int arrayCapacity = array.length;
        Object[] newArray = new Object[newCapacity];

        for (int i = 1, j = front + 1; i <= size; i++, j++) {
            newArray[i] = array[j % arrayCapacity];
        }
        this.array = null;
        this.array = newArray;
        front = 0;
        rear = size;
    }

    public boolean offerLast(final E e) {

        // 용적이 꽉찼을 경우 용적 2배로 resize
        if ((rear + 1) % array.length == front) {
            resize(2 * array.length);
        }

        rear = (rear + 1) % array.length;   // rear을 rear 다음 위치로 갱신
        array[rear] = e;

        size++;
        return true;
    }

    @Override
    public boolean offer(final E e) {
        return offerLast(e);
    }

    public boolean offerFirst(E e) {
        if ((front - 1 + array.length) % array.length == rear) {
            resize(2 * array.length);
        }

        array[front] = e; // front는 애초에 빈 공간이기에 먼저 e를 넣어준다.
        front = (front - 1 + array.length) % array.length;

        size++;
        return true;
    }

    @Override
    public E peek() {
        E target = peekFirst();
        if (target == null) {
            throw new NoSuchElementException();
        }
        return target;
    }

    public E peekFirst() {
        if (size == 0) {
            return null;
        }
        @SuppressWarnings("unchecked")
        E target = (E) array[front + 1 % array.length];
        return target;
    }

    public E peekLast() {
        if (size == 0) {
            return null;
        }
        @SuppressWarnings("unchecked")
        E target = (E) array[rear];
        return target;
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    public E pollFirst() {
        // API상 Poll은 Null Return
        if (size == 0) {
            return null;
        }
        front = (front + 1) % array.length;

        // 입출력이 모두 E Type에 한정된다.
        @SuppressWarnings("unchecked")
        E target = (E) array[front];

        array[front] = null;
        size--;

        if (array.length > DEFAULT_CAPACITY && size < array.length / 2) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }
        return target;
    }

    public E pollLast() {
        if (size == 0) {
            return null;
        }
        @SuppressWarnings("unchecked")
        E target = (E) array[rear];
        array[rear] = null;

        rear = (rear - 1 + array.length) % array.length;
        size--;

        if (array.length > DEFAULT_CAPACITY && size < array.length / 2) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

        return target;

    }

    public E removeLast() {
        E target = pollLast();
        if (target == null) {
            throw new NoSuchElementException();
        }
        return target;
    }

    public E remove() {
        return removeFirst();
    }

    public E removeFirst() {
        E item = pollFirst();
        if (item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    // TODO : 파라미터로 E Type을 넣는게 적절할까?
    // Object Type을 넣는 것은 부적절할까? 
    public boolean contains(E e) {
        int index = front + 1 % array.length;
        for (int i = 0, j = index; i < size; i++, j = (j + 1) % array.length) {
            if (e.equals((E)array[j])) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        rear = front = size = 0;
    }
}
