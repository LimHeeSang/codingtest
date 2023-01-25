package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bruteforce29_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        String[] s = br.readLine().split(" ");
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + Integer.parseInt(s[i - 1]);
        }

        int count = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                if (dp[j] - dp[i - 1] == m) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
