package baekjoon.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs4_7576 {
    static int m;
    static int n;

    static int[][] graph;
    static boolean[][] visited;


    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());   //가로
        n = Integer.parseInt(st.nextToken());   //세로

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs();
        int max = 0;
        loop : for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] > max) max = graph[i][j];
                if(graph[i][j] == 0){
                    max = 0;
                    break loop;
                }
            }
        }

        bw.write(String.valueOf(max - 1));
        bw.flush();
        bw.close();
    }

    static void dfs() {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 1){
                    q.offer(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = node.x + dx[i];
                int my = node.y + dy[i];

                if ((mx < 0 || mx >= n) || (my < 0 || my >= m)) continue;
                if (graph[mx][my] != -1 && !visited[mx][my]) {
                    graph[mx][my] = graph[node.x][node.y] + 1;
                    q.offer(new Node(mx, my));
                    visited[mx][my] = true;
                }
            }
        }

    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
