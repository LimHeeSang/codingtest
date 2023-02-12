package baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideConquer5_1517 {

    static int[] arr;
    static int[] sorted;
    static long swapCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sorted = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        divide(0, n - 1);
        System.out.println(swapCount);
    }

    static void divide(int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        divide(left, mid);
        divide(mid + 1, right);
        merge(left, mid, right);
    }

    static void merge(int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int index = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                sorted[index++] = arr[l++];
            } else {
                sorted[index++] = arr[r++];
                swapCount += (mid + 1 - l);
            }
        }

        while (l <= mid) {
            sorted[index++] = arr[l++];
        }
        while (r <= right) {
            sorted[index++] = arr[r++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
}
