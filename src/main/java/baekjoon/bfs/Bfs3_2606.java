package baekjoon.bfs;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.util.*;

public class Bfs3_2606 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int [][] graph = new int[n+1][n+1];
        boolean [] visited = new boolean[n+1];
        StringTokenizer st;
        int x, y;

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        int count = 0;

        while(!q.isEmpty()) {

            int temp = q.poll();

            for(int i=0; i<n+1; i++) {
                if(graph[temp][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    q.offer(i);
                    count++;
                }

            }

        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }

}