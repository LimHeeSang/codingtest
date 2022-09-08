package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class String5_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        String[] arr = new String[t];
        for (int i = 0; i < t; i++) {
            arr[i] = br.readLine();
        }

        for (String a : arr) {
            calculate(a);
        }
    }

    public static void calculate(String s) {
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (q.isEmpty() || ch == q.peek()) {
                q.offer(ch);
            } else if (ch != q.peek() && ch == ')') {
                q.poll();
            } else {
                q.offer(ch);
            }
        }

        if (q.size() == 0) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
}
