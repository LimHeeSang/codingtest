package baekjoon.dynamic;

import java.io.*;

public class Dynamic7_2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(n >= 1) dp[0] = arr[0];
        if(n >= 2) dp[1] = dp[0] + arr[1];
        if(n >= 3) dp[2] = Math.max(arr[0], arr[1]) + arr[2];

        if(n >=3){
            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
            }
        }

        bw.write(String.valueOf(dp[n - 1]));
        bw.flush();
        bw.close();
    }
}
