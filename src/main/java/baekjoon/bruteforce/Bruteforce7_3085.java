package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bruteforce7_3085 {
    static final int C = 1;
    static final int P = 2;
    static final int Z = 3;
    static final int Y = 4;

    static int answer = 0;

    static int n;
    static int[][] map;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] splited = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (splited[j].equals("C")) {
                    map[i][j] = C;
                } else if (splited[j].equals("P")) {
                    map[i][j] = P;
                } else if (splited[j].equals("Z")) {
                    map[i][j] = Z;
                } else if (splited[j].equals("Y")) {
                    map[i][j] = Y;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                changePosition(new Point(i, j));
            }
        }

        System.out.println(answer);
    }

    private static void changePosition(Point p) {
        for (int i = 0; i < 2; i++) {
            int mx = p.x + dx[i];
            int my = p.y + dy[i];

            if (mx < 0 || mx >= n || my < 0 || my >= n) {
                continue;
            }

            if (map[mx][my] != map[p.x][p.y]) {
                changeValue(p, new Point(mx, my));
                countMaxCandy();
                changeValue(p, new Point(mx, my));
            }
        }
    }

    private static void countMaxCandy() {
        int preValue = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            preValue = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == preValue) {
                    count++;
                }
                if (map[i][j] != preValue || j == n - 1) {
                    answer = Math.max(answer, count);
                    count = 1;
                }
                preValue = map[i][j];
            }
        }

        preValue = 0;
        count = 1;
        for (int i = 0; i < n; i++) {
            preValue = 0;
            for (int j = 0; j < n; j++) {
                if (map[j][i] == preValue) {
                    count++;
                }
                if (map[j][i] != preValue || j == n - 1) {
                    answer = Math.max(answer, count);
                    count = 1;
                }
                preValue = map[j][i];
            }
        }

    }

    private static void changeValue(Point p1, Point p2) {
        int temp = map[p1.x][p1.y];
        map[p1.x][p1.y] = map[p2.x][p2.y];
        map[p2.x][p2.y] = temp;
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