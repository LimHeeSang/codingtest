package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra11_2665 {

    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                dist[i][j] = 51;
            }
        }

        dijkstra(new Point(0, 0));
        System.out.println(dist[n - 1][n - 1]);
    }

    static void dijkstra(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            Point curN = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = curN.x + dx[i];
                int my = curN.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (map[mx][my] == 0 && dist[mx][my] > dist[curN.x][curN.y] + 1) {
                    dist[mx][my] = dist[curN.x][curN.y] + 1;
                    q.offer(new Point(mx, my));
                } else if (map[mx][my] == 1 && dist[mx][my] > dist[curN.x][curN.y]) {
                    dist[mx][my] = dist[curN.x][curN.y];
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
