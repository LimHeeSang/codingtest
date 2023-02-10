package baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DivideConquer4_2447 {

    static int n;
    static char[][] map;
    static boolean[][] isBlank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        isBlank = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = '*';
            }
        }

        dfs(0, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isBlank[i][j]) {
                    bw.write(" ");
                } else {
                    bw.write(String.valueOf(map[i][j]));
                }
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int row, int col, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 3;
        for (int i = row + newSize; i < row + newSize * 2; i++) {
            for (int j = col + newSize; j < col + newSize * 2; j++) {
                isBlank[i][j] = true;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dfs(row + newSize * i, col + newSize * j, newSize);
            }
        }
    }
}
