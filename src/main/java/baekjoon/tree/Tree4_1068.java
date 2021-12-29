package baekjoon.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tree4_1068 {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n];
        visited = new boolean[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a;
        int root = 0;
        for (int i = 0; i < n; i++) {
            a = Integer.parseInt(st.nextToken());

            if (a == -1) {
                root = i;
            } else {
                graph[a].add(i);
            }
            parent[i] = a;
        }

        int d = Integer.parseInt(br.readLine());
        int pNode = parent[d];
        if(!(pNode == -1)){
            List list = graph[pNode];
            list.remove(Integer.valueOf(d));
            dfs(root);
        }else {
            count = 0;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }

    static void dfs(int data) {
        visited[data] = true;

        if (graph[data].isEmpty()) {
            count++;
            return;
        }

        for (int i = 0; i < graph[data].size(); i++) {
            if (!visited[graph[data].get(i)]) {
                dfs(graph[data].get(i));
            }

        }
    }

}
