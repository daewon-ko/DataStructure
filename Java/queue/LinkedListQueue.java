package Java.queue;

public class LinkedListQueue<E> implements Queue<E> {
    private int size;
    private Node<E> tail;
    private Node<E> head;

    // 기본 생성자 작성
    public LinkedListQueue() {
        this.size = 0;
        this.tail= null;
        this.head = null;
    }

    @Override
    public boolean offer(final E e) {
        return false;
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
