package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Greedy15_1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int left = 0;
        int right = 2;
        int answer = -1;
        while (right < n) {
            if (arr[left] < arr[left + 1] + arr[right]) {
                answer = arr[left] + arr[left + 1] + arr[right];
                break;
            }
            left++;
            right++;
        }

        System.out.println(answer);
    }
}
