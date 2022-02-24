package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Bfs7_14502 {

    static int n;
    static int m;

    static int[][] graph;
    static int[][] virusGraph;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static Point[] wallList;
    static boolean[] visited;
    static Point[] wallInfo = new Point[3];

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        virusGraph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*makeWall2(0);*/

        initWallList();
        makeWall(0, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static void initWallList() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 0) count++;
            }
        }
        wallList = new Point[count];
        visited = new boolean[count];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 0) wallList[idx++] = new Point(i, j);
            }
        }
    }

    static void makeWall(int r, int idx) {
        if (r == 3) {
            bfs();
            return;
        }

        for (int i = idx; i < wallList.length; i++) {
            if (!visited[i]) {
                wallInfo[r] = wallList[i];
                visited[i] = true;
                makeWall(r + 1, i + 1);
                visited[i] = false;
            }
        }

    }

    static void bfs() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                virusGraph[i][j] = graph[i][j];

        for (int i = 0; i < 3; i++) {
            virusGraph[wallInfo[i].x][wallInfo[i].y] = 1;
        }

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(virusGraph[i][j] == 2) q.offer(new Point(i, j));
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = p.x + dx[i];
                int my = p.y + dy[i];

                if((mx < 0 || mx >= n) || (my < 0 || my >= m)) continue;
                if (virusGraph[mx][my] == 0) {
                    virusGraph[mx][my] = 2;
                    q.offer(new Point(mx, my));
                }
            }
        }

        answer();
    }

    static void answer() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(virusGraph[i][j] == 0) count++;
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
