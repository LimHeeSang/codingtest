package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class DataStructure6_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();
        for (int i = n; i > 0; i--) {
            dq.offer(i);
        }

        boolean check = true;
        while (dq.size() != 1) {
            if (check) {
                dq.pollLast();
            } else {
                int temp = dq.pollLast();
                dq.offerFirst(temp);
            }
            check = !check;
        }

        System.out.println(dq.getFirst());
    }
}
