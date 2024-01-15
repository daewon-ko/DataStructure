package Java.queue;

public class LinkedListQueue<E> implements Queue<E> {
    private int size;
    private Node<E> tail;
    private Node<E> head;

    // 기본 생성자 작성
    public LinkedListQueue() {
        this.size = 0;
        this.tail = null;
        this.head = null;
    }

    @Override
    public boolean offer(final E e) {
        Node<E> newNode = new Node<>(e);

        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        size++;
        tail = newNode;
        return true;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        }

        E target = head.data;

        head.data = null;
        head.next = null;

        head = head.next;

        size--;
        return target;
    }
}
