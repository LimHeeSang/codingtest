package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs11_2178 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] splited = br.readLine().split("");

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(splited[j]);
            }
        }

        bfs();
        System.out.println(map[n-1][m-1]);
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();

        q.offer(new Point(0, 0));

        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = point.x + dx[i];
                int my = point.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }

                if (map[mx][my] == 1) {
                    map[mx][my] += map[point.x][point.y];
                    q.offer(new Point(mx, my));
                    visited[mx][my] = true;
                }
            }
        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
