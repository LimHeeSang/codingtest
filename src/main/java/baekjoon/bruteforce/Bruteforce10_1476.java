package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bruteforce10_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;
        int eStart = 0;
        int sStart = 0;
        int mStart = 0;
        while (true) {
            if (eStart == e && sStart == s && mStart == m) {
                break;
            }
            eStart++;
            sStart++;
            mStart++;

            if (eStart > 15) {
                eStart = 1;
            }
            if (sStart > 28) {
                sStart = 1;
            }
            if (mStart > 19) {
                mStart = 1;
            }
            count++;
        }
        System.out.println(count);
    }
}
