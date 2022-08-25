package jungol.shape;

import java.io.*;
import java.util.StringTokenizer;

public class Shape10_1523 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] result = new char[n][n];

        if (n > 100 || n < 0 || m < 0 || m > 3) {
            System.out.println("INPUT ERROR");
            return;
        }

        if (m == 1) {
            printMenu1(result);
        }
        if (m == 2) {
            printMenu2(result);
        }
        int y = 0;
        if (m == 3) {
             y = calculateY(n);
            result = new char[n][y];
            printMenu3(result, y);
        }

        for (int i = 0; i < n; i++) {
            int k;
            if (m == 1 || m == 2) {
                k = n;
            } else {
                k = y;
            }

            for (int j = 0; j < k; j++) {
                if (result[i][j] == 0) {
                    bw.write(" " + " ");
                } else {
                    bw.write(result[i][j] + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static int calculateY(int n) {
        int num = 1;
        while (n != 1) {
            num += 2;
            n--;
        }
        return num;
    }

    public static void printMenu1(char[][] result) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                result[i][j] = '*';
            }
        }
    }

    public static void printMenu2(char[][] result) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - 1 - i; j++) {
                result[i][j] = '*';
            }
        }
    }

    public static void printMenu3(char[][] result, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = y / 2 - i; j <= y / 2 + i; j++) {
                result[i][j] = '*';
            }
        }
    }
}
