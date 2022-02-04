package programmers.heap;
import java.util.*;

//heap1 더 맵게
class Heap1 {
    public int solution(int[] scoville, int K) {
        int count = 0;


        Queue<Integer> q = new PriorityQueue<>();
        for(int s : scoville){
            q.offer(s);
        }

        while(q.peek() < K){
            int food1 = q.poll();
            int food2 = q.poll();

            q.offer(food1 + food2 * 2);

            count++;

            if(q.size() == 1 && q.peek() < K) return -1;
        }

        return count;
    }
}
