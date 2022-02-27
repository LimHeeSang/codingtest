package baekjoon.dynamic;

import java.io.*;

public class Dynamic14_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[100];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;

        for (int i = 5; i < 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        int m;
        for (int i = 0; i < t; i++) {
            m = Integer.parseInt(br.readLine());
            bw.write(dp[m-1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
