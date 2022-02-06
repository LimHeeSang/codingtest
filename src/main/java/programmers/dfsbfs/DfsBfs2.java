package programmers.dfsbfs;
import java.util.*;

//dfsbfs2 네트워크
class DfsBfs2 {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];

        List<List<Integer>> graph = new LinkedList<>();
        for(int i=0; i<n; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(computers[i][j] == 1){
                    list.add(j);
                }
            }
            graph.add(list);
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(visited, graph, i);
                count++;
            }
        }

        return count;
    }

    public void bfs(boolean[] visited, List<List<Integer>> graph, int start){
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int temp = q.poll();

            for(int num : graph.get(temp)){
                if(!visited[num]){
                    q.offer(num);
                    visited[num] = true;

                }
            }
        }

    }

}
