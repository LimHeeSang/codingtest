package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph9_2146 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int[][] map;
    static boolean[][] bridgeArea;
    static int bridgeNumber = 2;
    static int bridgeLength = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        bridgeArea = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    bridgeArea[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    List<Point> islandPoints = getIslandPoint(new Point(i, j));
                    bfs(islandPoints, bridgeNumber - 1);
                }
            }
        }
        System.out.println(bridgeLength);
    }

    static void bfs(List<Point> starts, int nowBridgeNumber) {
        List<Integer> points = new ArrayList<>();
        int[][] copyMap = makeCopyMap(map);

        Queue<Point> q = new LinkedList<>();
        for (Point start : starts) {
            q.offer(start);
        }

        while (!q.isEmpty()) {
            Point curP = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = curP.x + dx[i];
                int my = curP.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (copyMap[mx][my] == 0) {
                    copyMap[mx][my] = copyMap[curP.x][curP.y] + 1;
                    q.offer(new Point(mx, my));
                }
                if (copyMap[mx][my] != 0 && bridgeArea[mx][my] && copyMap[mx][my] != nowBridgeNumber) {
                    points.add(copyMap[curP.x][curP.y] - nowBridgeNumber);
                }
            }
        }

        for (int point : points) {
            bridgeLength = Math.min(bridgeLength, point);
        }
    }

    private static int[][] makeCopyMap(int[][] map) {
        int[][] newMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }

    static List<Point> getIslandPoint(Point start) {
        boolean[][] visited = new boolean[n][n];
        List<Point> points = new ArrayList<>();

        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        points.add(start);
        visited[start.x][start.y] = true;
        map[start.x][start.y] = bridgeNumber;

        while (!q.isEmpty()) {
            Point curP = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = curP.x + dx[i];
                int my = curP.y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }

                if (!visited[mx][my] && map[mx][my] == 1) {
                    visited[mx][my] = true;
                    map[mx][my] = bridgeNumber;
                    q.offer(new Point(mx, my));
                    points.add(new Point(mx, my));
                }
            }
        }
        bridgeNumber++;
        return points;
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
