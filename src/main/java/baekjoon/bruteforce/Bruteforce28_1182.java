package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bruteforce28_1182 {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        dfs(arr, 0, 0, n, s);
        if (s == 0) {
            System.out.println(answer - 1);
            return;
        }
        System.out.println(answer);
    }

    static void dfs(int[] arr, int sum, int depth, int n, int s) {
        if (depth == n) {
            if (sum == s) {
                answer++;
            }
            return;
        }

        dfs(arr, sum + arr[depth], depth + 1, n, s);
        dfs(arr, sum, depth + 1, n, s);
    }
}
