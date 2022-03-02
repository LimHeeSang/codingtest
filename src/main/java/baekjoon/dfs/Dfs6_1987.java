package baekjoon.dfs;

import java.io.*;
import java.util.*;

public class Dfs6_1987 {
    static int r;
    static int c;
    static int max = 0;

    static int[][] graph;
    static boolean[][] visited;

    static boolean[] check = new boolean[26];

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        graph = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                graph[i][j] = temp.charAt(j) - 'A';
            }
        }

        dfs(new Point(0, 0), 1);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    static void dfs(Point point, int count) {
        max = Math.max(count, max);

        visited[point.x][point.y] = true;
        check[graph[point.x][point.y]] = true;

        for (int i = 0; i < 4; i++) {
            int mx = point.x + dx[i];
            int my = point.y + dy[i];

            if(mx < 0 || mx >= r || my < 0 || my >= c) continue;
            if (!visited[mx][my] && !check[graph[mx][my]]) {
                dfs(new Point(mx, my), count + 1);
                visited[mx][my] = false;
                check[graph[mx][my]] = false;
            }
        }

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
