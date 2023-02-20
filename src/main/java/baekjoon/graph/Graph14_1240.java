package baekjoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph14_1240 {

    static int n;
    static int m;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        graph = new int[n + 1][n + 1];

        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start][end] = cost;
            graph[end][start] = cost;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(calculateDistance(start, end) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int calculateDistance(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(visited, false);
        q.offer(start);
        visited[start] = true;

        int[] distance = new int[n + 1];
        while (!q.isEmpty()) {
            int curN = q.poll();
            if (curN == end) {
                return distance[end];
            }

            for (int i = 1; i < n + 1; i++) {
                if (!visited[i] && graph[curN][i] != 0) {
                    distance[i] += distance[curN] + graph[curN][i];
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return 0;
    }
}
