package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking2_15650 {

    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        result = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        comb(m, 0, 0);
    }

    static void comb(int m, int start, int idx) {
        if (m == 0) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                result[idx] = arr[i];
                visited[i] = true;
                comb(m - 1, i + 1, idx + 1);
                visited[i] = false;
            }
        }
    }
}
