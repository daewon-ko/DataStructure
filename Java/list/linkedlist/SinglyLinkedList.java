package Java.list.linkedlist;

import Java.Node;
import Java.list.List;

import java.util.NoSuchElementException;

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

        /**
         * x.next는 null로 초기화 되어있지 않나?
         * List자체가 아무 것도 없을 경우에 NULL QKSGHKS
         */
        for (int count = 0; count < index; count++) {
            x = x.next;
        }
        return x;

    }

    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;

        /**
         * if Node가 null일 경우
         * Node의 tail과 head가 같다.
         */
        if (newNode.next == null) {
            tail = head;
        }
    }

    /**
     * add는 사실상 addLast와 같고 Java에서 제공하는 add의 일반적인 기능이
     *
     * @param value
     * @return
     */
    @Override
    public boolean add(final E value) {
        Node<E> newNode = new Node<E>(value);
        if (size == 0) {
            addFirst(value);
            return true;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
        return true;
    }

    @Override
    public void add(final int index, final E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            add(value);
            return;
        }
        Node<E> preNode = search(index - 1);
        Node<E> nextNode = preNode.next;

        Node<E> newNode = new Node<>(value);

        preNode.next = null;
        preNode.next = newNode;
        newNode.next = nextNode;
        size++;

    }
    public E remove() {
        Node<E> headNode = head;
        // head를 조회했으나 null일 경우 Exception을 던진다.
        if (headNode == null) {
            throw new NoSuchElementException();
        }

        E element = headNode.data;
        Node<E> nextNode = headNode.next;

        headNode.next = null;
        headNode.data = null;

        head = nextNode;
        size--;

        if (size == 0) {
            tail = null;
        }
        return element;


    }

    @Override
    public E remove(final int index){
        if (index == 0) {
            remove();
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        Node<E> prevNode = search(index - 1);
        Node<E> removedNode = prevNode.next;
        Node<E> nextNode = removedNode.next;

        // 삭제될 Data
        E element = removedNode.data;

        // 이전 노드의 다음을 nextNode로 변경
        prevNode.next = nextNode;
        // 삭제 data가 null일경우
        // TODO : 삭제 data가 null이라는 말의 의미가 무엇일까?
        if (removedNode.next == null) {
            tail = prevNode;
        }

        removedNode.data = null;
        removedNode.next = null;
        size --;
        return element;


    }

    @Override
    public boolean remove(final Object value) {

        return false;
    }

    @Override
    public E get(final int index) {
        return search(index).data;
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

        Node<E> objectNode = search(index);
        return objectNode.data = value;
    }

    @Override
    public int lastIndexOf(final E value) {
        return 0;
    }

    @Override
    public void clear() {

    }
}
