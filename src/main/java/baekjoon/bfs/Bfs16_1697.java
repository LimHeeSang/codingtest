package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs16_1697 {

    static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Arrays.fill(arr, Integer.MAX_VALUE);

        bfs(n);
        System.out.println(arr[k]);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        arr[start] = 0;

        while (!q.isEmpty()) {
            int curNum = q.poll();

            if (curNum - 1 >= 0 && arr[curNum] + 1 < arr[curNum - 1]) {
                arr[curNum - 1] = arr[curNum] + 1;
                q.offer(curNum - 1);
            }
            if (curNum + 1 <= 100000 && arr[curNum] + 1 < arr[curNum + 1]) {
                arr[curNum + 1] = arr[curNum] + 1;
                q.offer(curNum + 1);
            }
            if (curNum * 2 <= 100000 && arr[curNum] + 1 < arr[curNum * 2]) {
                arr[curNum * 2] = arr[curNum] + 1;
                q.offer(curNum * 2);
            }
        }
    }
}
