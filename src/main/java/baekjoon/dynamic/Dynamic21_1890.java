package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Dynamic21_1890 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) {
                    break;
                }

                if (dp[i][j] != 0) {
                    if (j + map[i][j] < n) {
                        dp[i][j + map[i][j]] += dp[i][j];
                    }
                    if (i + map[i][j] < n) {
                        dp[i + map[i][j]][j] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}
