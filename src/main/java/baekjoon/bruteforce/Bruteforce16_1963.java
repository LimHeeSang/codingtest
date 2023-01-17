package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bruteforce16_1963 {

    static int answer;
    static int[] count;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        prime = new boolean[10000];
        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);

            count = new int[10000];
            Arrays.fill(count, Integer.MAX_VALUE);

            makePrime();
            answer = Integer.MAX_VALUE;
            bfs(start);
            System.out.println(count[end]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        count[start] = 0;

        while (!q.isEmpty()) {
            int curN = q.poll();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (i == 0 & j == 0) {
                        continue;
                    }
                    int changeN = change(curN, i, j);
                    if (prime[changeN] && count[curN] + 1 < count[changeN]) {
                        count[changeN] = count[curN] + 1;
                        q.offer(changeN);
                    }
                }
            }

        }
    }

    static int change(int curN, int i, int j) {
        // curN의 i번째 자리를 j로 바꾸기
        StringBuilder sb = new StringBuilder(String.valueOf(curN));
        sb.setCharAt(i, (char) ('0' + j));
        return Integer.parseInt(sb.toString());
    }

    static void makePrime() {
        Arrays.fill(prime, true);
        prime[1] = false;

        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }
    }
}
