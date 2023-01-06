package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs17_12851 {

    static int[] arr = new int[100001];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Arrays.fill(arr, Integer.MAX_VALUE);

        if (n >= k) {
            System.out.println(n - k);
            System.out.println(1);
            return;
        }

        bfs(n, k);
        System.out.println(arr[k]);
        System.out.println(count);
    }

    static void bfs(int start, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        arr[start] = 0;

        int minTime = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int curNum = q.poll();

            if (arr[curNum] > minTime) {
                continue;
            }

            for (int i = 0; i < 3; i++) {
                int nxtNum;
                if (i == 0) {
                    nxtNum = curNum - 1;
                } else if (i == 1) {
                    nxtNum = curNum + 1;
                } else {
                    nxtNum = curNum * 2;
                }

                if (nxtNum < 0 || nxtNum > 100000) {
                    continue;
                }

                if (nxtNum == k) {
                    minTime = arr[curNum];
                    count++;
                }

                if (arr[curNum] + 1 <= arr[nxtNum]) {
                    arr[nxtNum] = arr[curNum] + 1;
                    q.offer(nxtNum);
                }

            }
        }
    }
}
