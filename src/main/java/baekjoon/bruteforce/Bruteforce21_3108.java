package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bruteforce21_3108 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map; // -1: 방문 못하는 곳, 0: 방문 해야하는 곳, 1: 방문 한 곳
    static int m = 2001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(map[i], -1);
        }
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int x2 = Integer.parseInt(s[1]);
            int y1 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);
            willVisited(new Point((x1 + 500) * 2, (x2 + 500) * 2), new Point((y1 + 500) * 2, (y2 + 500) * 2));
        }

        int count = 0;
        draw(new Point(1000, 1000));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    draw(new Point(i, j));
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void draw(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        map[start.x][start.y] = 1;

        while (!q.isEmpty()) {
            Point curP = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = curP.x + dx[i];
                int my = curP.y + dy[i];

                if (mx < 0 || mx >= m || my < 0 || my >= m) {
                    continue;
                }
                if (map[mx][my] == 0) {
                    q.offer(new Point(mx, my));
                    map[mx][my] = 1;
                }
            }
        }
    }


    // 두개의 좌표를 주어지면 map에 0으로 처리
    static void willVisited(Point left, Point right) {
        for (int i = left.x; i <= right.x; i++) {
            map[i][left.y] = 0;
            map[i][right.y] = 0;
        }
        for (int i = left.y; i <= right.y; i++) {
            map[left.x][i] = 0;
            map[right.x][i] = 0;
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
