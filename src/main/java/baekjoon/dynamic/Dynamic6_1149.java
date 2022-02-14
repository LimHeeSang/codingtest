package baekjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Dynamic6_1149 {

    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
            dp[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<n; i++){
            dp[i][RED] += Math.min(dp[i-1][GREEN], dp[i-1][BLUE]);
            dp[i][GREEN] += Math.min(dp[i - 1][RED], dp[i - 1][BLUE]);
            dp[i][BLUE] += Math.min(dp[i - 1][RED], dp[i - 1][GREEN]);
        }

        int answer = Math.min(dp[n-1][RED], Math.min(dp[n-1][GREEN], dp[n-1][BLUE]));
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

}
