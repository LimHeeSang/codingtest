package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bruteforce30_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int start = 0;
        int end = 0;
        int sum = arr[start];
        int count = 0;

        while (end < n) {
            if (sum >= target) {
                if (sum == target) {
                    count++;
                }
                sum -= arr[start];
                start++;
            } else {
                end++;
                sum += arr[end];
            }
        }

        System.out.println(count);
    }
}
