package baekjoon.bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs6_2468 {
    static int n;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j] > max) max = graph[i][j];
            }
        }

        int count;
        int answer = 0;
        for (int i = 0; i <= max; i++) {
            count = 0;
            initVisited();
            afterRain(i);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k]) {
                        bfs(new Point(j, k));
                        count++;
                    }
                }
            }
            if(count > answer) answer = count;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    static void initVisited() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    static void afterRain(int height) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j] <= height) visited[i][j] = true;
            }
        }
    }

    static void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = point.x + dx[i];
                int my = point.y + dy[i];

                if(mx < 0 || mx >= n || my < 0 || my >= n) continue;
                if (!visited[mx][my]) {
                    q.offer(new Point(mx, my));
                    visited[mx][my] = true;
                }
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
