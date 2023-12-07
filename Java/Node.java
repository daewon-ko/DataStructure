package Java;

public class Node <E>{
    E data;
    Node <E> next;

    public Node(final E data) {
        this.data = data;
        this.next = null;
    }
}
