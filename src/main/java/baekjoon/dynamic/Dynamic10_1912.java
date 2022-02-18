package baekjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Dynamic10_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[][] dp = new int[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + arr[j];
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(max < dp[i][j]) max = dp[i][j];
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
