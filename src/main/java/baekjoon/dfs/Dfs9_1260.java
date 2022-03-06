package baekjoon.dfs;
import java.io.*;
import java.util.*;

public class Dfs9_1260 {

    static int n;
    static int[][] graph;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(v);
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.println();

        Arrays.fill(visited, false);
        result.clear();

        bfs(v);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    //dfs
    static void dfs(int start) {
        result.add(start);
        visited[start] = true;

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i] && graph[start][i] == 1) {
                dfs(i);
            }
        }
    }

    //bfs
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            result.add(temp);

            for (int i = 1; i < n + 1; i++) {
                if (!visited[i] && graph[temp][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }

    }
}
