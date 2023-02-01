package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy12_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] times = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[1];
            }
            return a[1] - b[1];
        });

        int count = 0;
        int preEndTime = 0;
        for (int[] time : times) {
            if (time[0] >= preEndTime) {
                count++;
                preEndTime = time[1];
            }
        }
        System.out.println(count);
    }
}
