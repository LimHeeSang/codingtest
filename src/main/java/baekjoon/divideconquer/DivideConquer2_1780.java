package baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideConquer2_1780 {

    static int n;
    static int minusCount = 0;
    static int zeroCount = 0;
    static int oneCount = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(s[j]);
            }
        }

        dfs(0, 0, n);
        System.out.println(minusCount);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }

    static void dfs(int row, int col, int size) {
        if (isAllSameNumber(row, col, size)) {
            if (paper[row][col] == -1) {
                minusCount++;
            } else if (paper[row][col] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            return;
        }

        int newSize = size / 3;
        dfs(row, col, newSize);
        dfs(row, col + newSize, newSize);
        dfs(row, col + newSize * 2, newSize);

        dfs(row + newSize, col, newSize);
        dfs(row + newSize, col + newSize, newSize);
        dfs(row + newSize, col + newSize * 2, newSize);

        dfs(row + newSize * 2, col, newSize);
        dfs(row + newSize * 2, col + newSize, newSize);
        dfs(row + newSize * 2, col + newSize * 2, newSize);
    }

    static boolean isAllSameNumber(int row, int col, int size) {
        int color = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
