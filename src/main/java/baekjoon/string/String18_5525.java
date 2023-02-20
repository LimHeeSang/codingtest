package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String18_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();
        int[] count = new int[m];
        int answer = 0;

        for (int i = 1; i < m - 1; i++) {
            if (arr[i] == 'O' && arr[i + 1] == 'I') {
                count[i + 1] = count[i - 1] + 1;

                if (count[i + 1] >= n && arr[i - 2 * n + 1] == 'I') {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
