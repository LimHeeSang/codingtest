package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Greedy13_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(p);

        int answer = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += p[i];
            answer += sum;
        }
        System.out.println(answer);
    }
}
