package baekjoon.prefixsum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PrefixSum1_11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] sum = new int[n];
        String numbers = br.readLine();
        String[] split = numbers.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            if (start == end) {
                bw.write(arr[start] + "\n");
            } else {
                int answer;
                if (start == 0) {
                    answer = sum[end];
                }else {
                    answer = sum[end] - sum[start - 1];
                }
                bw.write(answer + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
