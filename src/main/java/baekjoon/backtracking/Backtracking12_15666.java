package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Backtracking12_15666 {
    static int n;
    static int m;

    static int[] arr;
    static int[] temp;
    static Set<String> result = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        temp = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dupPerm(m, 0, 0);

        for (String str : result) {
            System.out.println(str);
        }
    }

    // 1 7 9 9
    static void dupPerm(int m, int idx, int start) {
        if (m == 0) {
            StringBuilder sb = new StringBuilder();
            for (int t : temp) {
                sb.append(t).append(" ");
            }
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < n; i++) {
            temp[idx] = arr[i];
            dupPerm(m - 1, idx + 1, i);
        }
    }
}
