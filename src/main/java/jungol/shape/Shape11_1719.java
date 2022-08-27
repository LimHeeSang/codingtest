package jungol.shape;

import java.io.*;
import java.util.StringTokenizer;

public class Shape11_1719 {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int menu = Integer.parseInt(st.nextToken());
        int m;
        if (menu == 1 || menu == 2) {
            m = n / 2 + 1;
        } else {
            m = n;
        }
        char[][] result = new char[n][m];

        if (menu == 1) {
            menu1(result);
        }
        if (menu == 2) {
            menu2(result);
        }
        if (menu == 3) {
            menu3(result);
        }
        if (menu == 4) {
            menu4(result);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == 0) {
                    bw.write(" ");
                } else {
                    bw.write(String.valueOf(result[i][j]));
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void menu1(char[][] result) {
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n - i; j++) {
                result[j][i] = '*';
            }
        }
    }

    public static void menu2(char[][] result) {
        for (int i = 0; i < m; i++) {
            for (int j = n / 2 - i; j <= n / 2 + i; j++) {
                result[j][i] = '*';
            }
        }
    }

    public static void menu3(char[][] result) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i; j++) {
                result[i][j] = '*';
            }
        }
        for (int i = n / 2; i < n; i++) {
            for (int j = m / 2 - i; j <= m / 2 + i; j++) {
                result[i][j] = '*';
            }
        }
    }

    public static void menu4(char[][] result) {
        for (int i = 0; i < n / 2; i++) {
            for (int j = m / 2 - i; j <= m / 2; j++) {
                result[i][j] = '*';
            }
        }
        for (int i = n / 2; i < n; i++) {
            for (int j = m / 2; j <= m / 2 + i; j++) {
                result[i][j] = '*';
            }
        }
    }
}
