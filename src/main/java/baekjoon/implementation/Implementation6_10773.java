package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Implementation6_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                dq.pollLast();
            } else {
                dq.offer(num);
            }
        }

        int answer = 0;
        for (int num : dq) {
            answer += num;
        }

        System.out.println(answer);
    }
}
