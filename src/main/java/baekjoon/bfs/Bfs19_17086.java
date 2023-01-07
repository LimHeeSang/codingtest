package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs19_17086 {

    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 1) {
                    answer = Math.max(answer, bfs(new Point(i, j, 0)));
                    initVisited();
                }
            }
        }
        System.out.println(answer);
    }

    static void initVisited() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
    }


    static int bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point curP = q.poll();

            for (int i = 0; i < 8; i++) {
                int mx = curP.x + dx[i];
                int my = curP.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }

                if (map[mx][my] == 1) {
                    return curP.distance + 1;
                }
                if (!visited[mx][my]) {
                    q.offer(new Point(mx, my, curP.distance + 1));
                    visited[mx][my] = true;
                }
            }
        }
        return 0;
    }

    static class Point {
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
