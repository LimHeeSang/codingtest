package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bruteforce23_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] arr = new int[f + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        arr[s] = 0;

        while (!q.isEmpty()) {
            int curN = q.poll();

            if (curN - d > 0 && arr[curN] + 1 < arr[curN - d]) {
                arr[curN - d] = arr[curN] + 1;
                q.offer(curN - d);
            }
            if (curN + u <= f && arr[curN] + 1 < arr[curN + u]) {
                arr[curN + u] = arr[curN] + 1;
                q.offer(curN + u);
            }
        }
        System.out.println(arr[g] == Integer.MAX_VALUE ? "use the stairs" : arr[g]);
    }
}
