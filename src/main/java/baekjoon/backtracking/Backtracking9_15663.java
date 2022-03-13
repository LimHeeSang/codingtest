package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Backtracking9_15663 {
    static int n;
    static int m;

    static int[] arr;
    static int[] temp;
    static Set<String> result = new LinkedHashSet<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        temp = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dupPerm(m, 0);

        for (String str : result) {
            System.out.println(str);
        }
    }

    static void dupPerm(int m, int idx) {
        if (m == 0) {
            StringBuilder sb = new StringBuilder();
            for (int t : temp) {
                sb.append(t).append(" ");
            }
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                temp[idx] = arr[i];
                visited[i] = true;
                dupPerm(m - 1, idx + 1);
                visited[i] = false;
            }
        }
    }
}