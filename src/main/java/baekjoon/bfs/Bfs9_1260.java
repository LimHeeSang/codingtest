package baekjoon.bfs;
import java.io.*;
import java.util.*;

public class Bfs9_1260 {

    static List<List<Integer>> graph = new LinkedList<>();
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        for (int i = 0; i < n+1; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(v);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();

        Arrays.fill(visited, false);
        result.clear();

        bfs(v);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    //dfs
    static void dfs(int start) {
        result.add(start);
        visited[start] = true;

        for (int i : graph.get(start)) {
            if (!visited[i]) {
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
            int i = q.poll();
            result.add(i);

            for (int g : graph.get(i)) {
                if (!visited[g]) {
                    q.offer(g);
                    visited[g] = true;
                }
            }
        }
    }
}
