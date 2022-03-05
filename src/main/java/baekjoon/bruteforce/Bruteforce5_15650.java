package baekjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Bruteforce5_15650 {
    static int[] arr;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        result = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        comb(n, m, 0, 0);
    }

    static void comb(int n, int r, int start, int idx) {
        if (r == 0) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            if(!visited[i]){
                result[idx] = arr[i];
                visited[i] = true;
                comb(n, r - 1, i + 1, idx + 1);
                visited[i] = false;
            }
        }
    }
}
