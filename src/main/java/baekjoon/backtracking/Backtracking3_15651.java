package baekjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Backtracking3_15651 {
    static int n;
    static int m;
    static BufferedWriter bw;

    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        dupPerm(m, 0);
        bw.flush();
        bw.close();
    }

    static void dupPerm(int m, int idx) throws IOException {
        if (m == 0) {
            for (int i = 0; i < result.length; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            result[idx] = arr[i];
            dupPerm(m - 1, idx + 1);
        }
    }
}
