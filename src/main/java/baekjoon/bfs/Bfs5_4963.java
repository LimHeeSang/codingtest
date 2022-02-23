package baekjoon.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs5_4963 {
    static int w;
    static int h;

    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            graph = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        bfs(new Point(i, j));
                        count++;
                    }
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int mx = point.x + dx[i];
                int my = point.y + dy[i];

                if(mx < 0 || mx >= h || my < 0 || my >= w) continue;
                if (graph[mx][my] == 1 && !visited[mx][my]) {
                    q.offer(new Point(mx, my));
                    visited[mx][my] = true;
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
