package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy5_1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            q.offer(arr[i]);
        }

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (q.contains(arr[i])) {
                continue;
            }
            q.poll();
            count++;
            q.offer(arr[i]);
        }
        System.out.println(count);
    }
}
