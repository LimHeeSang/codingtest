package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bruteforce35_7453 {

    static int n;
    static int[] a;
    static int[] b;
    static int[] c;
    static int[] d;

    static int[] ab;
    static int[] cd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];
        ab = new int[n * n];
        cd = new int[n * n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[idx] = a[i] + b[j];
                cd[idx++] = c[i] + d[j];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        System.out.println(twoPointer());
    }

    static long twoPointer() {
        long count = 0;
        int left = 0;
        int right = n * n - 1;
        int sum = 0;

        while (left < n * n && right >= 0) {
            sum = ab[left] + cd[right];

            if (sum == 0) {
                int count1 = 0;
                int leftValue = ab[left];
                while (left < n * n && ab[left] == leftValue) {
                    left++;
                    count1++;
                }

                int count2 = 0;
                int rightValue = cd[right];
                while (right >= 0 && cd[right] == rightValue) {
                    right--;
                    count2++;
                }
                count += ((long) count1 * count2);
            } else if (sum < 0) {
                left++;
            } else {    // sum > 0
                right--;
            }
        }
        return count;
    }
}
