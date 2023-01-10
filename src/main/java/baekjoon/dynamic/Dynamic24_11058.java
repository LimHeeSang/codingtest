package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dynamic24_11058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] count = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            count[i] = count[i - 1] + 1;
            for (int j = 1; j <= i - 3; j++) {
                count[i] = Math.max(count[i], count[i - (j + 2)] * (j + 1));
            }
        }
        System.out.println(count[n]);
    }
}
