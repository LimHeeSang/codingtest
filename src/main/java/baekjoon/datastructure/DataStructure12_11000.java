package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DataStructure12_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            input[i][0] = start;
            input[i][1] = end;
        }

        Arrays.sort(input, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });


        PriorityQueue<Integer> pq = new PriorityQueue<>();  //강의의 끝나는 시간 저장
        pq.offer(input[0][1]);

        for (int i = 1; i < n; i++) {
            int startTime = input[i][0];
            int endTime = input[i][1];

            if (pq.peek() <= startTime) {
                pq.poll();
            }
            pq.offer(endTime);
        }

        System.out.println(pq.size());
    }

}
