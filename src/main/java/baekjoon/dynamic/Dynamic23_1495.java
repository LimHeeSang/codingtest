package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Dynamic23_1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] v = new int[n + 1];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < s1.length; i++) {
            v[i + 1] = Integer.parseInt(s1[i]);
        }

        int[] dp = new int[m + 1];
        Arrays.fill(dp, -1);
        dp[s] = 0;

        for (int i = 1; i <= n; i++) {
            // i번째 곡 연주 계산
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= m; j++) {
                if (dp[j] == i - 1) {
                    int minus = j - v[i];
                    int plus = j + v[i];
                    if (minus >= 0) {
                        list.add(minus);
                    }
                    if (plus <= m) {
                        list.add(plus);
                    }
                }
            }
            for (int nxt : list) {
                dp[nxt] = i;
            }
        }

        for (int i = m; i >= 0; i--) {
            if (dp[i] == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
