package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bruteforce26_1987 {

    static int r;
    static int c;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;
    static boolean[] alphabet = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        alphabet[map[0][0] - 'A'] = true;
        dfs(new Point(0, 0), 1);
        System.out.println(answer);
    }

    static void dfs(Point point, int depth) {
        answer = Math.max(answer, depth);

        for (int i = 0; i < 4; i++) {
            int mx = point.x + dx[i];
            int my = point.y + dy[i];

            if (mx < 0 || mx >= r || my < 0 || my >= c) {
                continue;
            }

            if (!alphabet[map[mx][my] - 'A']) {
                alphabet[map[mx][my] - 'A'] = true;
                dfs(new Point(mx, my), depth + 1);
                alphabet[map[mx][my] - 'A'] = false;
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
