package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra5_18352 {
    static final int INF = Integer.MAX_VALUE;

    static int n;
    static int m;

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        dijkstra(start);

        boolean check = false;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == k) {
                check = true;
                System.out.println(i);
            }
        }
        if (!check) {
            System.out.println(-1);
        }

    }

    static void dijkstra(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;
        visited[start] = true;

        while (!q.isEmpty()) {
            int curNode = q.poll();

            for (int nxtNode : graph.get(curNode)) {
                if(visited[nxtNode]) continue;
                if(dist[nxtNode] > dist[curNode] + 1){
                    dist[nxtNode] = dist[curNode] + 1;
                    q.offer(nxtNode);
                    visited[nxtNode] = true;
                }
            }

        }

    }

}
