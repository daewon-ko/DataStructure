package Java;

public class Node <E>{
    public E data;
    public Node <E> next;

    public Node(final E data) {
        this.data = data;
        this.next = null;
    }
}
