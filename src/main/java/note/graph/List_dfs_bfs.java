package note.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class List_dfs_bfs {

    static int n;
    static int m;
    static int start;

    static List<List<Integer>> graph;

    static boolean[] visited = new boolean[n + 1];
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        Arrays.fill(visited, false);

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하기 위해 정렬수행
        for(int i=0; i<n+1; i++) {
            Collections.sort(graph.get(i));
        }

        // dfs함수 실행 args: start;
        dfs(start);

        System.out.println();
        Arrays.fill(visited, false);
        // bfs함수 실행 args: start;
        bfs(start);

    }

    static public void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for(int i:graph.get(start)) {
            if(visited[i] == false)
                dfs(i);
        }

    }

    static public void bfs(int start) {
        q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            System.out.print(temp + " ");

            for (int i : graph.get(temp)) {
                if (visited[i] == false) {
                    q.offer(i);
                    visited[i] = true;
                }
            }

        }

    }

}
