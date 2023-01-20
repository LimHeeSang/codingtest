package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bruteforce20_2186 {

    static int n;
    static int m;
    static int k;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][][] dp;
    static char[][] map;
    static char[] answer;
    static int answerLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        answer = br.readLine().toCharArray();
        answerLength = answer.length;

        dp = new int[n][m][answerLength];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == answer[0]) {
                    count += dfs(i, j, 0);
                }
            }
        }
        System.out.println(count);
    }

    static int dfs(int x, int y, int depth) {
        if (dp[x][y][depth] != -1) {
            return dp[x][y][depth];
        }

        if (depth == answerLength - 1) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int mx = x;
            int my = y;
            for (int j = 0; j < k; j++) {
                mx += dx[i];
                my += dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }
                if (map[mx][my] == answer[depth + 1]) {
                    count += dfs(mx, my, depth + 1);
                }
            }
        }
        return dp[x][y][depth] = count;
    }
}
