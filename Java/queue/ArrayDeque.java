package Java.queue;

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
        this.array =  null;
        this.array = newArray;
        front= 0;
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
        return null;
    }

    @Override
    public E poll() {
        return null;
    }
}
