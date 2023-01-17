package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bruteforce15_1697 {

    static int[] arr;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[100001];

        if (k <= n) {
            System.out.println(n - k);
            return;
        }

        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[n] = 0;
        bfs(n);
        System.out.println(arr[k]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int curNode = q.poll();

            if (curNode == k) {
                return;
            }

            if (curNode + 1 <= 100000 && arr[curNode] + 1 < arr[curNode + 1]) {
                arr[curNode + 1] = arr[curNode] + 1;
                q.offer(curNode + 1);
            }
            if (curNode - 1 >= 0 && arr[curNode] + 1 < arr[curNode - 1]) {
                arr[curNode - 1] = arr[curNode] + 1;
                q.offer(curNode - 1);
            }
            if (curNode * 2 <= 100000 && arr[curNode] + 1 < arr[curNode * 2]) {
                arr[curNode * 2] = arr[curNode] + 1;
                q.offer(curNode * 2);
            }
        }
    }
}
