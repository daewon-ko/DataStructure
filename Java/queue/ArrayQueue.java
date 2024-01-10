package Java.queue;

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
            resize(2* arrayCapacity);
        }
        rear = (rear + 1) % arrayCapacity;  // rear의 위치를 갱신한다.(원형으로 생각)
        array[rear] = e;
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
