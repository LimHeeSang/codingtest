package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dynamic20_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = Integer.MIN_VALUE;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];
        int[] t = new int[n+2];
        int[] p = new int[n+2];

        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=n+1;i++) {
            //최대금액 갱신
            max = Math.max(max, dp[i]);

            //dp배열 채워줌
            if(i+t[i] <= n+1)
                dp[i+t[i]] = Math.max(max+p[i], dp[i+t[i]]);

        }
        System.out.println(max);
    }
}
