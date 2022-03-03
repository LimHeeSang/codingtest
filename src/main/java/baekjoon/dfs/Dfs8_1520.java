package baekjoon.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class Dfs8_1520 {

    static int m;
    static int n;

    static int[][] graph;
    static int[][] dp;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        dp = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = dfs(new Point(0, 0));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static int dfs(Point point) {
        if (point.x == m - 1 && point.y == n - 1) {
            return 1;
        }

        visited[point.x][point.y] = true;

        for (int i = 0; i < 4; i++) {
            int mx = point.x + dx[i];
            int my = point.y + dy[i];

            if(mx < 0 || mx >= m || my < 0 || my >= n) continue;
            if(graph[point.x][point.y] > graph[mx][my]){
                if (!visited[mx][my]) {
                    dp[point.x][point.y] += dfs(new Point(mx, my));
                }else{
                    dp[point.x][point.y] += dp[mx][my];
                }
            }
        }

        return dp[point.x][point.y];
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
