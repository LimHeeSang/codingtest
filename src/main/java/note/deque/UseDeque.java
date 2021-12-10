package note.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class UseDeque {

    public static void main(String[] args) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new LinkedBlockingDeque<>();
        Deque<Integer> deque3 = new ConcurrentLinkedDeque<>();
        Deque<Integer> deque4 = new LinkedList<>();


        deque1.addFirst(1);   // 덱의 앞쪽에 데이터 e를 추가
        deque1.offerFirst(2);  // 덱의 앞쪽에 데이터 e를 추가
        deque1.addLast(3);    // 덱의 뒷쪽에 데이터 e를 추가, add(Element e) 함수와 동일한 기능
        deque1.offerLast(4);  // 덱의 뒷쪽에 데이터 e를 추가, offer(Element e) 힘수와 동일한 기능

        deque1.removeFirst();    // 덱의 앞쪽의 데이터 삭제, 리턴, remove()함수와 동일한 기능
        deque1.removeLast();     // 덱의 뒷쪽의 데이터 삭제, 리턴
        deque1.pollFirst();      // 덱의 앞쪽의 데이터 삭제, 리턴, poll() 함수와 동일한 기능
        deque1.pollLast();       // 덱의 뒷쪽의 데이터 삭제, 리턴

        deque1.getFirst();       // 덱의 앞쪽 데이터를 삭제하지 않고 리턴
        deque1.getLast();        // 덱의 뒷쪽 데이터를 삭제하지 않고 리턴
        deque1.peekFirst();      // 덱의 앞쪽 데이터를 삭제하지 않고 리턴
        deque1.peekLast();       // 덱의 뒷쪽 데이터를 삭제하지 않고 리턴, peek()과 동일한 기능

        deque1.size();           // 덱의 크기 리턴
    }

}
