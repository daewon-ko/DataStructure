package Java.queue;

public class ArrayQueue implements Queue {

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

    @Override
    public boolean offer(final Object o) {
        return false;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public Object poll() {
        return null;
    }
}
