package Java.list.linkedlist;

import Java.list.List;

import java.awt.desktop.AppReopenedEvent;
import java.util.NoSuchElementException;

public class DoubleLinkedList<E> implements List<E> {
    private Node2<E> head;
    private Node2<E> tail;
    private int size;

    // 기본 초기화
    // 처음 DoubleLinkedList 초기화시에, 이전 Node와 이후 Node를 가리킬 수 없다.
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * 이전 SingleLinkedList와 같이 특정 index가 주어지면,
     * Node를 찾아주는 메서드
     *
     * @param index
     * @return
     */

    private Node2<E> search(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index + 1 > size / 2) {
            Node2<E> target = tail;
            for (int count = size - 1; count > index; count--) {
                target = target.prev;
            }
            return target;
        } else {
            Node2<E> target = head;
            for (int count = 0; count < index; count++) {
                target = target.next;
            }
            return target;
        }


    }


    public void addFirst(E value) {
        Node2<E> newNode = new Node2<>(value);
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
        size++;

        if (head.next == null) {
            tail = head;
        }

    }

    @Override
    public boolean add(final E value) {
        Node2<E> newNode = new Node2<>(value);
        if (size == 0) {
            addFirst(value);
            return true;
        }
        newNode = tail.next;
        tail = newNode.prev;
        newNode = tail;
        size++;
        return true;
    }

    @Override
    public void add(final int index, final E value) {
        if (index < 0 || index >= size) {
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
        Node2<E> newNode = new Node2<>(value);

        Node2<E> prevNode = search(index - 1);
        Node2<E> nextNode = prevNode.next;


        // 링크해제
        prevNode.next = null;
        nextNode.prev = null;

        Node2<E> insertNode = new Node2<>(value);

        insertNode.prev = prevNode;
        insertNode.next = nextNode;

        prevNode.next = insertNode;
        nextNode.prev = insertNode;
        size++;

    }

    /**
     * 첫번째 INDEX Node를 삭제하는 메서드
     * 실제 Java에서도 List Interface에는 없지만,
     * LinkedList 클래스 내에는 존재한다.
     * @return
     */
    public E remove() {
        Node2<E> headNode = head;
        // size가 0이면, 제거할 Node가 없으므로 exception를 던진다.
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node2<E> nextNode = head.next;

        // return할 element를 미리 꺼내놓는다.
        E element = head.data;

        // head의 data와 nextNode를 null를 입력한다.
        head.data = null;
        head.next = null;

        // nextNode가 null이 아닐 시에 nextNode의 prev값을 null처리 해준다.
        if (nextNode != null) {
            nextNode.prev = null;
        }

        nextNode = head;
        size--;

        if (size == 0) {
            tail = null;
        }

        return element;
    }

    @Override
    public E remove(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            E element = head.data;
            remove();
            return element;
        }


        Node2<E> prevNode = search(index - 1);
        Node2<E> removedNode = prevNode.next;
        Node2<E> nextNode = removedNode.next;

        E element = removedNode.data;

        prevNode = null;
        removedNode.prev = null;
        removedNode.next = null;
        removedNode.data = null;

        // prevNode의 경우, 위의 if문에서 index가 0인경우 조건처리를 해주므로 null일 수 없다.
        if (nextNode != null) {
            nextNode.prev = null;
            nextNode.prev = prevNode;
            prevNode.next = nextNode;
        } else {
            tail = prevNode;
        }

        size --;
        return element;
    }

    @Override
    public boolean remove(final Object value) {
        Node2<E> prevNode = head;
        Node2<E> x = head;

        for (; x != null; x = x.next) {
            if (x.data.equals(value)) {
                break;
            }
            prevNode = x;
        }
        if (x == null) {
            return false;
        }

        if (x.equals(head)) {
            remove();
            return true;
        } else {
            Node2<E> nextNode = x.next;

            /** prevNode의 경우 위의 if문에서 head와 일치하는 조건에 대한 분기가 있으므로
             * null 체크가 필요없다.
             */

            prevNode.next = null;
            x.data = null;
            x.next = null;
            x.prev = null;


            if (nextNode != null) {
                nextNode.prev = null;

                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            } else {
                tail = prevNode;
            }

            size --;
            return true;


        }
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
        int index = 0;

        for (Node2<E> x = head; x != null; x = x.next) {
            if (value.equals(x.data)) {
                return index;
            }
            index++;
        }
        return -1;
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
        Node2<E> targetNode = search(index);
        targetNode.data = null;
        targetNode.data = value;
        return value;
    }

    @Override
    public int lastIndexOf(final E value) {
        int index = size -1;

        for (Node2<E> x = tail; x != null; x = x.prev) {
            if (value.equals(x.data)) {
                return index;
            }
            index--;
        }
        return -1;
    }

    @Override
    public void clear() {

    }
}
