package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph6_2667 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int[][] map;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    bfs(new Point(i, j));
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int r : result) {
            System.out.println(r);
        }
    }

    static void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        map[start.x][start.y] = 0;
        int count = 1;

        while (!q.isEmpty()) {
            Point curP = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = curP.x + dx[i];
                int my = curP.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (map[mx][my] == 1) {
                    map[mx][my] = 0;
                    q.offer(new Point(mx, my));
                    count++;
                }
            }
        }

        result.add(count);
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
