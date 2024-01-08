package Java.stack;

/**
 * Java에서는 Stack Class가 Vector라는 Class를 extends하지만,
 * 자료구조를 구현해보는 취지에 맞춰서 Stack을 Interface로 재정의한다.
 * 이 재정의한 인터페이스를 구현하는 Stack Class를 만듬을 통해서
 * 메서드를 반드시 구현하도록 한다. (Interface의 특징)
 */
public interface StackInterface<E> {
    E push(E item);

    E pop();

    E peek();

    int search(Object value);

    int size();

    void clear();

    boolean empty();
}
