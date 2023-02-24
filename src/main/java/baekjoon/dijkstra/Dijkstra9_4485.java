package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra9_4485 {

    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCount = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            map = new int[n][n];
            dist = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] splited = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(splited[j]);
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs();
            bw.write("Problem " + testCount++ + ": " + dist[n - 1][n - 1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        dist[0][0] = map[0][0];

        while (!q.isEmpty()) {
            Point curP = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = curP.x + dx[i];
                int my = curP.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (dist[mx][my] > dist[curP.x][curP.y] + map[mx][my]) {
                    dist[mx][my] = dist[curP.x][curP.y] + map[mx][my];
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
