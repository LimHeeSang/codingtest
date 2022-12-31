package programmers.bruteforce;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 전력망을 둘로 나누기
 */
public class BruteForce4 {

    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] wire : wires){
            int start = wire[0];
            int end = wire[1];

            graph.get(start).add(end);
            graph.get(end).add(start);
        }


        for(int[] wire : wires){
            int start = wire[0];
            int end = wire[1];

            graph.get(start).remove(Integer.valueOf(end));
            graph.get(end).remove(Integer.valueOf(start));

            calculateCount(n, start, end, graph);

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        return answer;
    }

    void calculateCount(int n, int start, int end, List<List<Integer>> graph){
        int startCount = countNode(n, start, graph);
        int endCount = countNode(n, end, graph);
        int result = Math.abs(startCount - endCount);
        System.out.println(result);
        answer = Math.min(answer, result);
    }

    int countNode(int n, int start, List<List<Integer>> graph){
        int count = 0;

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        count++;

        while(!q.isEmpty()){
            int curNode = q.poll();

            List<Integer> list = graph.get(curNode);
            for(int nxtNode : list){
                if(!visited[nxtNode]){
                    q.offer(nxtNode);
                    visited[nxtNode] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
