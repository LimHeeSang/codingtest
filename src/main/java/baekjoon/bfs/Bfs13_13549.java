package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs13_13549 {
    static int n;
    static int k;
    static int[] graph = new int[100001];
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(graph[k]);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.offer(n);
        graph[n] = 0;
        visited[n] = true;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x * 2 <= 100000 && !visited[x * 2]) {
                q.offer(x * 2);
                graph[x * 2] = graph[x];
                visited[x * 2] = true;
            }

            if (x - 1 >= 0 && !visited[x - 1]) {
                q.offer(x - 1);
                graph[x - 1] = graph[x] + 1;
                visited[x - 1] = true;
            }
            if (x + 1 <= 100000 && !visited[x + 1]) {
                q.offer(x + 1);
                graph[x + 1] = graph[x] + 1;
                visited[x + 1] = true;
            }

        }
    }
}
