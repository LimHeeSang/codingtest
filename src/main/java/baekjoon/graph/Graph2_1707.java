package baekjoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph2_1707 {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static boolean[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            graph = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            visited = new boolean[v + 1];
            value = new boolean[v + 1];
            boolean answer = true;

            for (int i = 0; i < v + 1; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph.get(start).add(end);
                graph.get(end).add(start);
            }

            for (int i = 1; i < v + 1; i++) {
                if (!answer) {
                    break;
                }
                if (!visited[i]) {
                    answer = isBipartiteGraph(i);
                }
            }
            bw.write((answer ? "YES" : "NO") + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isBipartiteGraph(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        value[start] = false;

        while (!q.isEmpty()) {
            int curN = q.poll();

            for (int nxtN : graph.get(curN)) {
                if (visited[nxtN] && value[nxtN] == value[curN]) {
                    return false;
                }
                if (!visited[nxtN]) {
                    value[nxtN] = !value[curN];
                    visited[nxtN] = true;
                    q.offer(nxtN);
                }
            }
        }
        return true;
    }
}
