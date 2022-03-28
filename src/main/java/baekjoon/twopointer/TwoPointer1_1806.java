package baekjoon.twopointer;

import java.io.*;
import java.util.StringTokenizer;

public class TwoPointer1_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        int sum = arr[0];
        int length = 1;
        while (true) {
            if (sum >= s) {
                answer = Math.min(length, answer);
                sum -= arr[left];
                left++;
                length--;
            }
            if (sum < s) {
                right++;
                if(right >= n) break;
                sum += arr[right];
                length++;
            }
        }
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }

        System.out.println(answer);
    }
}
