package baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideConquer3_1992 {

    static int n;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        dfs(0, 0, n, 0);
        System.out.println(sb);
    }

    static void dfs(int row, int col, int size, int count) {
        if (isAllSameNumberThat(row, col, size, 0)) {
            sb.append(0);
            return;
        }
        if (isAllSameNumberThat(row, col, size, 1)) {
            sb.append(1);
            return;
        }

        int newSize = size / 2;
        sb.append("(");
        dfs(row, col, newSize, count + 1);
        dfs(row, col + newSize, newSize, count + 1);
        dfs(row + newSize, col, newSize, count + 1);
        dfs(row + newSize, col + newSize, newSize, count + 1);
        sb.append(")");
    }

    static boolean isAllSameNumberThat(int row, int col, int size, int target) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != target) {
                    return false;
                }
            }
        }
        return true;
    }
}
