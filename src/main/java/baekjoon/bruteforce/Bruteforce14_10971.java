package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bruteforce14_10971 {

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 0);
            Arrays.fill(visited, false);
        }
        System.out.println(answer);
    }

    static void dfs(int start, int end, int cost) {
        if (map[start][end] != 0 && isAllVisited()) {
            answer = Math.min(answer, cost + map[start][end]);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (map[start][i] != 0 && !visited[i]) {
                visited[i] = true;
                dfs(i, end, cost + map[start][i]);
                visited[i] = false;
            }
        }
    }

    static boolean isAllVisited() {
        for (boolean flag : visited) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
