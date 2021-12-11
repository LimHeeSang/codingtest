package note.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Array_dfs_bfs {

    static int n;
    static int m;
    static int v;
    static int[][] graph;
    static boolean[] visited;

    static Queue<Integer> q;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        // dfs 함수 호출
        dfs(v);

        System.out.println();
        Arrays.fill(visited, false);

        // bfs 함수 호출
        bfs(v);
    }

    static public void dfs(int start)   {
        visited[start] = true;

        System.out.print(start + " ");

        for(int i=0; i<n+1; i++) {
            if(graph[start][i] == 1 && visited[i] == false)
                dfs(i);
        }
    }

    static public void bfs(int start) {
        q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int temp = q.poll();

            System.out.print(temp + " ");

            for(int i=0; i<n+1; i++) {
                if(graph[temp][i] == 1 && visited[i] == false) {
                    q.offer(i);
                    visited[i] = true;
                }

            }

        }
    }

}
