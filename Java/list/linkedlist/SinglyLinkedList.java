package Java.list.linkedlist;

import Java.Node;
import Java.list.List;

/**
 * 자바에는 SinglyLinkedList라는 클래스는 존재하지 않지만, 개념적으로는
 * LinkedList와 유사하다.
 *
 * @param <E>
 */

public class SinglyLinkedList<E> implements List<E> {
    private Node<E> head;   // Node의 처음
    private Node<E> tail;   // Node의 마지막
    private int size;   // 요소 개수

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * 특정 위치의 index로 Node<E>를 찾는다.
     *
     * @param index
     * @return
     */
    //Todo : 더 좋은 방식은 없을까? 가령, index가 뒷부분이라면 앞에서부터 찾아나가는 방식은 적합하지 않다.
    public Node<E> search(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> x = head;   // head라고 상정

        for (int count = 0; count < index; count++) {
            x = x.next;
        }
        return x;

    }

    public void addFirst(E value) {
        

    }

    @Override
    public boolean add(final E value) {
        return false;
    }

    @Override
    public void add(final int index, final E value) {

    }

    @Override
    public E remove(final int index) {
        return null;
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
    public E set(final int index, final E value) {
        return null;
    }

    @Override
    public int lastIndexOf(final E value) {
        return 0;
    }

    @Override
    public void clear() {

    }
}
