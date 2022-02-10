package programmers.graph;
import java.util.*;

//graph2 순위
class Graph2 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        final int INF = 100000;

        int[][] graph = new int[n+1][n+1];
        for(int i=0; i<graph.length; i++){
            Arrays.fill(graph[i], INF);
        }


        for(int i=0; i<results.length; i++){
            graph[results[i][0]][results[i][1]] = 1;
        }


        //거쳐가는 노드t
        for (int t = 1; t < n + 1; t++) {
            //시작 노드 i
            for (int i = 0; i < n + 1; i++) {
                //도착 노드j
                for (int j = 0; j < n + 1; j++) {
                    if (graph[i][t] + graph[t][j] < graph[i][j]) {
                        graph[i][j] = graph[i][t] + graph[t][j];
                    }
                }
            }
        }

        for(int i=1; i<n+1; i++){
            int result=0;
            for(int j=1; j<n+1; j++){
                if(graph[i][j] < INF || graph[j][i] < INF){result++;}
            }
            if(result==n-1){answer++;}
        }


        return answer;
    }
}
