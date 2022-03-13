package baekjoon.backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backtracking5_15654 {
    static int n;
    static int m;
    static BufferedWriter bw;

    static int[] arr;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        result = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
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
            if(!visited[i]){
                result[idx] = arr[i];
                visited[i] = true;
                dupPerm(m - 1, idx + 1);
                visited[i] = false;
            }
        }
    }
}
