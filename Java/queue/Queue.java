package Java.queue;

/**
 * 자바 Queue Interface
 * 해당 Queue는 ArrayQueue, ArrayDeque, PriorityQueue, LinkedListQueue 등에 의해 구현
 * 기타 add(E e)와 같은 메서드도 존재하지만, Queue라는 자료구조 자체에 집중하기 위해
 * 하단의 3가지 메서드만 구현한다.
 *
 * @author pinetree
 * @param <E>
 */
public interface Queue <E>{

    /**
     * Queue의 가장 마지막에 요소를 추가
     * @param e
     * @return 정상적으로 e가 추가시, true를 반환
     */
    boolean offer(E e);

    /**
     * Queue의 가장 첫번째 요소를 반환
     * @return
     */
    E peek();

    /**
     * Queue의 가장 첫번째 요소를 삭제하며 반환
     * @return
     */

    E poll();
}
