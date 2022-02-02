package programmers.stackqueue;
import java.util.*;

//stackqueue2 프린터
class StackQueue2 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            q.offer(new Node(i, priorities[i]));
        }

        int max = 0;
        int count = 0;
        while(!q.isEmpty()){
            max = Collections.max(q).priority;

            Node n = q.poll();
            if(n.priority == max){
                count++;
                if(n.idx == location){
                    answer = count;
                    break;
                }
            }else{
                q.offer(n);
            }
        }

        return answer;
    }


    static class Node implements Comparable<Node>{
        int idx;
        int priority;

        Node(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }

        public int compareTo(Node n){
            return priority - n.priority;
        }
    }

}
