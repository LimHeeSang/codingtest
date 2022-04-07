package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking13_2294 {
    static int answer = Integer.MAX_VALUE;
    static int n;
    static int k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }

    static void dfs(int count, int sum) {
        if (count >= answer) {
            return;
        }

        if (sum >= k) {
            if (sum == k) {
                answer = Math.min(answer, count);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            dfs(count + 1, sum + arr[i]);
        }
    }
}