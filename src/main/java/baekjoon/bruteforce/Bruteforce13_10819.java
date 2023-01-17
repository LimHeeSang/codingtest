package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bruteforce13_10819 {

    static int n;
    static int[] arr;
    static boolean[] visited;
    static int[] result;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        result = new int[n];
        visited = new boolean[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == n) {

            //수열 계산
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(result[i] - result[i + 1]);
            }
            answer = Math.max(answer, sum);

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result[depth] = arr[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
