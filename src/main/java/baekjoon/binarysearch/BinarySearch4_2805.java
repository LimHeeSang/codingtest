package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch4_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        String[] splited = br.readLine().split(" ");
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(splited[i]);
            max = Math.max(max, arr[i]);
        }

        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] >= mid) {
                    sum += arr[i] - mid;
                }
            }

            if (sum >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
