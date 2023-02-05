package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph7_7576 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        List<Point> starts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    starts.add(new Point(i, j));
                }
            }
        }
        bfs(starts);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, map[i][j]);
            }
        }
        System.out.println(answer - 1);
    }

    static void bfs(List<Point> starts) {
        Queue<Point> q = new LinkedList<>();
        for (Point start : starts) {
            q.offer(start);
        }

        while (!q.isEmpty()) {
            Point curP = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = curP.x + dx[i];
                int my = curP.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }

                if (map[mx][my] == 0) {
                    map[mx][my] = map[curP.x][curP.y] + 1;
                    q.offer(new Point(mx, my));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
