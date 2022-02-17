package baekjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Dynamic9_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = 0;
            while (st.hasMoreTokens()) {
                dp[i][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] += dp[i-1][j];
                } else if (j == n - 1) {
                    dp[i][j] += dp[i - 1][j - 1];
                }else{
                    dp[i][j] += Math.max(dp[i - 1][j-1], dp[i - 1][j]);
                }
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[n - 1][i], max);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
