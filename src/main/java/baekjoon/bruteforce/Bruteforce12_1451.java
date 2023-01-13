package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bruteforce12_1451 {

    static int n;
    static int m;
    static int[][] map;
    static long[][] sum;
    static long answer = Long.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        sum = new long[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j < split.length + 1; j++) {
                map[i][j] = Integer.parseInt(split[j - 1]);
            }
        }

        // 직사각형 숫자 합계 세팅
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + map[i][j];
            }
        }

        //1번 case
        for (int i = 1; i <= m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                long r1 = sum(1, 1, n, i);
                long r2 = sum(1, i + 1, n, j);
                long r3 = sum(1, j + 1, n, m);
                answer = Math.max(answer, r1 * r2 * r3);
            }
        }

        //2번 case
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                long r1 = sum(1, 1, i, m);
                long r2 = sum(i + 1, 1, j, m);
                long r3 = sum(j + 1, 1, n, m);
                answer = Math.max(answer, r1 * r2 * r3);
            }
        }

        //3번 case
        for (int i = 1; i <= m - 1; i++) {
            for (int j = 1; j <= n - 1; j++) {
                long r1 = sum(1, 1, n, i);
                long r2 = sum(1, i + 1, j, m);
                long r3 = sum(j + 1, i + 1, n, m);
                answer = Math.max(answer, r1 * r2 * r3);
            }
        }

        //4번 case
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n - 1; j++) {
                long r1 = sum(1, i, n, m);
                long r2 = sum(1, 1, j, i - 1);
                long r3 = sum(j + 1, 1, n, i - 1);
                answer = Math.max(answer, r1 * r2 * r3);
            }
        }

        //5번 case
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= m - 1; j++) {
                long r1 = sum(1, 1, i, m);
                long r2 = sum(i + 1, 1, n, j);
                long r3 = sum(i + 1, j + 1, n, m);
                answer = Math.max(answer, r1 * r2 * r3);
            }
        }

        //6번 case
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m - 1; j++) {
                long r1 = sum(i, 1, n, m);
                long r2 = sum(1, 1, i - 1, j);
                long r3 = sum(1, j + 1, i - 1, m);
                answer = Math.max(answer, r1 * r2 * r3);
            }
        }
        System.out.println(answer);
    }

    static long sum(int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2]+sum[x1 - 1][y1 - 1];
    }
}
