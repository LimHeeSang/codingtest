package baekjoon.dynamic;

import java.io.*;

public class Dynamic15_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][n];

        if (n >= 1) {
            dp[0][0] = 0;
            dp[1][0] = 1;
        }
        if (n >= 2) {
            dp[0][1] = 1;
            dp[1][1] = 0;
        }

        for (int i = 2; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[1][i] = dp[0][i-1];
        }

        int answer = dp[0][n - 1] + dp[1][n - 1];
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
