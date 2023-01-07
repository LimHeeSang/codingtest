package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs18_13913 {

    static int[] arr = new int[100001];
    static List<Integer> route = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Arrays.fill(arr, Integer.MAX_VALUE);

        bfs(n);
        dfs(n, k);

        System.out.println(arr[k]);

        for (int i = route.size() - 1; i >= 0; i--) {
            System.out.print(route.get(i) + " ");
        }
        System.out.print(k + " ");
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        arr[start] = 0;

        while (!q.isEmpty()) {
            int curNum = q.poll();

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

                if (arr[curNum] + 1 <= arr[nxtNum]) {
                    arr[nxtNum] = arr[curNum] + 1;
                    q.offer(nxtNum);
                }

            }
        }
    }

    static void dfs(int n, int start) {
        if (start == n) {
            return;
        }

        int preNumber = Integer.MAX_VALUE;
        int minIdx = Integer.MAX_VALUE;
        if (start - 1 >= 0 && arr[start - 1] < preNumber) {
            preNumber = arr[start - 1];
            minIdx = start - 1;
        }
        if (start + 1 <= 100000 && arr[start + 1] < preNumber) {
            preNumber = arr[start + 1];
            minIdx = start + 1;
        }
        if (start > 0 && start % 2 == 0 && arr[start / 2] < preNumber) {
            preNumber = arr[start / 2];
            minIdx = start / 2;
        }
        route.add(minIdx);
        dfs(n, minIdx);
    }
}
