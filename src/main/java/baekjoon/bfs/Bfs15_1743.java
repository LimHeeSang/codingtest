package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs15_1743 {

    static boolean[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x - 1][y - 1] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]) {
                    bfs(new Point(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(Point point) {
        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        map[point.x][point.y] = false;

        int count = 1;
        while (!q.isEmpty()) {
            Point curPoint = q.poll();
            for (int i = 0; i < 4; i++) {
                int mx = curPoint.x + dx[i];
                int my = curPoint.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }
                if (map[mx][my]) {
                    map[mx][my] = false;
                    q.offer(new Point(mx, my));
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
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
