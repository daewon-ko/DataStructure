package Java.heap;

import java.util.Comparator;

public class Heap<E> {
    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10;	// 최소(기본) 용적 크기

    private int size;	// 요소 개수

    private Object[] array;	// 요소를 담을 배열

    // 생성자 Type 1 (초기 공간 할당 X)
    public Heap() {
        this(null);
    }

    public Heap(Comparator<? super E> comparator) {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    // 생성자 Type 2 (초기 공간 할당 O)
    public Heap(int capacity) {
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator) {
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }
}
