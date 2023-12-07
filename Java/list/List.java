package Java.list;

public interface List <E> {

    boolean add(E value);

    void add(int index, E value);

    E remove(int index);

    boolean remove(Object value);


    E get(int index);

    boolean contains(Object value);

    int indexOf(Object value);

    int size();

    boolean isEmpty();

    E set(int index, E value);

    int lastIndexOf(E value);


    public void clear();

}
