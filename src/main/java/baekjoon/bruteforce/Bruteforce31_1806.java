package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bruteforce31_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }

        int left =0;
        int right = 0;
        int sum = arr[0];
        int answer = Integer.MAX_VALUE;
        while (right < n) {
            if (sum >= target) {
                answer = Math.min(answer, right - left + 1);
                sum -= arr[left];
                left++;
            } else {
                right++;
                sum += arr[right];
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
