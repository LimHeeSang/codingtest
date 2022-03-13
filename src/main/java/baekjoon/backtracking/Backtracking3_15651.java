package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking3_15651 {
    static int n;
    static int m;

    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        dupPerm(m, 0);
    }

    static void dupPerm(int m, int idx) {
        if (m == 0) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            result[idx] = arr[i];
            dupPerm(m - 1, idx + 1);
        }
    }
}
