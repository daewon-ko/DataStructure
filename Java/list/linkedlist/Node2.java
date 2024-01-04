package Java.list.linkedlist;

public class Node2<E>{
    /**
     * DoubleLinkedList는 prevNode와 NextNode를 가져야 하므로 기존 Node Class와 다른 클래스를 생성
     */
    Node<E> prev;
    Node<E> next;
    E data;

    public Node2(E data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
