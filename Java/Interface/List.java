package Java.Interface;

public interface List <E> {

    boolean add(E value);

    void add(int index, E value);

    void remove(int index);

    boolean remove(Object value);


    E get(int index);

    boolean contains(Object value);

    int indexOf(Object value);

    int size();

    boolean isEmpty();

    public void clear();

}
