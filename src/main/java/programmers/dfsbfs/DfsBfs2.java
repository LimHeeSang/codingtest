package programmers.dfsbfs;
import java.util.*;

//dfsbfs2 네트워크
class DfsBfs2 {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(visited, computers, i);
                count++;
            }
        }

        return count;
    }

    public void dfs(boolean[] visited, int[][] computers, int start){
        visited[start] = true;

        for(int i=0; i<computers[start].length; i++){
            if(computers[start][i] == 1 && !visited[i]){
                dfs(visited, computers, i);
            }
        }
    }

}
