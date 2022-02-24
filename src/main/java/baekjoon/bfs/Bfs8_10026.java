package baekjoon.bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs8_10026 {
    static int n;

    static final int R = 0;
    static final int G = 1;
    static final int B = 2;
    static final int[] colors = {R, G, B};

    static String[][] temp;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        temp = new String[n][n];
        graph = new int[n][n];
        visited = new boolean[n][n];

        String s;
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            String[] splited = s.split("");
            for (int j = 0; j < n; j++) {
                temp[i][j] = splited[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(temp[i][j].equals("R")) graph[i][j] = R;
                else if(temp[i][j].equals("G")) graph[i][j] = G;
                else if(temp[i][j].equals("B")) graph[i][j] = B;
            }
        }

        int count = 0;
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == colors[k] && !visited[i][j]) {
                        bfs(new Point(i, j), colors[k]);
                        count++;
                    }
                }
            }
        }
        bw.write(count + " ");


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(temp[i][j].equals("R")) graph[i][j] = G;
            }
        }
        initVisited();

        count = 0;
        for (int k = 1; k < 3; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == colors[k] && !visited[i][j]) {
                        bfs(new Point(i, j), colors[k]);
                        count++;
                    }
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }



    static void bfs(Point point, int color) {
        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        visited[point.x][point.y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = p.x + dx[i];
                int my = p.y + dy[i];

                if((mx < 0 || mx >= n) || (my < 0 || my >= n)) continue;
                if (graph[mx][my] == color && !visited[mx][my]) {
                    q.offer(new Point(mx, my));
                    visited[mx][my] = true;
                }
            }
        }

    }

    static void initVisited() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
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
