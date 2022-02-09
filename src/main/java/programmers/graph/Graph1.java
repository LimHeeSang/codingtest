package programmers.graph;
import java.util.*;

//graph1 가장 먼 노드
class Graph1 {

    List<List<Integer>> graph;
    boolean[] visited;
    int[] result;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        visited = new boolean[n+1];
        result = new int[n+1];

        graph = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        result[0] = 0;
        bfs(1);

        int max = 0;
        for(int r : result) max = Math.max(max, r);

        for(int r : result){
            if(max == r) answer++;
        }

        return answer;
    }

    public void bfs(int start){
        int depth = 1;
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i : graph.get(temp)){
                if(!visited[i]){
                    q.offer(i);
                    visited[i] = true;
                    result[i] = result[temp] + 1;
                }
            }
        }

    }

}
