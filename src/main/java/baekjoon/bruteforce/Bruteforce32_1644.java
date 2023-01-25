package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bruteforce32_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        boolean[] isSosu = new boolean[n + 2];
        Arrays.fill(isSosu, true);
        isSosu[0] = false;
        isSosu[1] = false;
        for (int i = 2; i < isSosu.length; i++) {
            if (isSosu[i]) {
                for (int j = i + i; j < isSosu.length; j += i) {
                    isSosu[j] = false;
                }
            }
        }

        int left = 2;
        int right = 2;
        int sum = 2;
        int count = 0;
        while (right <= n) {
            if (sum >= n) {
                if (sum == n) {
                    count++;
                }
                sum -= left;
                do {
                    left++;
                } while (!isSosu[left] && left <= n);
            } else {
                do {
                    right++;
                } while (!isSosu[right] && right <= n);
                sum += right;
            }
        }
        System.out.println(count);
    }
}
