package Java.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 64;
    private Object[] array;
    private int size;
    private int front;
    private int rear;

    public ArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        size = 0;
        front = 0;
        rear = 0;
    }

    public ArrayQueue(int capacity) {
        this.array = new Object[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    /**
     * 멤버변수로 갖고있는 front, rear을 적극활용한다.
     * TODO: 아직은 이해가 확실히 안되었기에 추후 정리필요
     *
     * @param capacity 새로 생성할 배열의 크기
     */
    private void resize(int capacity) {
        int arrayCapacity = array.length;
        Object[] newArray = new Object[capacity];

        for (int i = 1, j = front + 1; i <= size; i++, j++) {
            newArray[i] = array[j % arrayCapacity];
        }
        this.array = null;
        this.array = newArray;
        front = 0;
        rear = size;
    }


    @Override
    public boolean offer(final E e) {
        int arrayCapacity = array.length;
        // 용적이 가득찰 경우 resize()를 해준다.
        if ((rear + 1) % arrayCapacity == front) {
            resize(2 * arrayCapacity);
        }
        rear = (rear + 1) % arrayCapacity;  // rear의 위치를 갱신한다.(원형으로 생각)
        array[rear] = e;
        size++;
        return true;
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        @SuppressWarnings("unchecked")
        E item = (E) array[(front + 1) % array.length];
        return item;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }
        front = (front + 1 % array.length);
        @SuppressWarnings("unchecked")
        E item = (E) array[front];
        array[front] = null;
        size--;

        //TODO : 하기의 If문은 어떤 조건에 의해서 작성되나?

        // 배열의 용적이 64개보다 크면서 요소의 개수가 용적의 1/4에 못 미칠 때 resize()를 한다.
        if (array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }
        return item;
    }

    public E element() {
        E item = peek();
        // null 체크
        if (item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }
}
