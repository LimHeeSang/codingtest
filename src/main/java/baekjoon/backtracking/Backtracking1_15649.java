package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking1_15649 {

    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        result = new int[m];
        for (int i = 1; i < n + 1; i++) {
            arr[i - 1] = i;
        }

        perm(n, m, 0);
    }

    //1 2 3 4
    static void perm(int n, int m, int idx) {
        if (m == 0) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result[idx] = arr[i];
                visited[i] = true;
                perm(n, m - 1, idx + 1);
                visited[i] = false;
            }
        }
    }
}
