package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra4_1261 {

    static final int INF = Integer.MAX_VALUE;

    static int n, m;
    static int[][] graph;
    static int[][] dist;


    static int[] dx = {0,0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        dijkstra(new Point(0, 0, 0));
        System.out.println(dist[n - 1][m - 1]);
    }

    static void dijkstra(Point point) {
        PriorityQueue<Point> q = new PriorityQueue<>(new Comparator<>(){
            public int compare(Point p1, Point p2) {
                return p1.broken - p2.broken;
            }
        });
        q.offer(point);
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            Point curPoint = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curPoint.x + dx[i];
                int nextY = curPoint.y + dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;

                if (dist[nextX][nextY] > curPoint.broken + graph[nextX][nextY]) {
                    dist[nextX][nextY] = curPoint.broken + graph[nextX][nextY];
                    q.offer(new Point(nextX, nextY, dist[nextX][nextY]));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int broken;

        Point(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }
}
