package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Dfs11_1260 {

    static List<TreeSet<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new TreeSet<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        visited[v] = true;
        System.out.print(v + " ");
        dfs(v);

        System.out.println();
        Arrays.fill(visited, false);
        bfs(v);
    }

    static void dfs(int curN) {

        for (int nxtN : graph.get(curN)) {
            if (!visited[nxtN]) {
                System.out.print(nxtN + " ");
                visited[nxtN] = true;
                dfs(nxtN);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curN = q.poll();
            System.out.print(curN + " ");

            for (int nxtN : graph.get(curN)) {
                if (!visited[nxtN]) {
                    q.offer(nxtN);
                    visited[nxtN] = true;

                }
            }
        }
    }
}
