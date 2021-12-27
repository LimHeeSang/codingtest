package baekjoon.tree;

import java.io.*;
import java.util.*;

public class Tree2_11725 {

    static List<List<Integer>> graph;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        parents = new int[n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        int a, b;
        for(int i=0; i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);
        for (int i = 2; i < parents.length; i++) {
            bw.write(parents[i]+" \n");
        }
        bw.flush();
        bw.close();

    }

    static void bfs(int data) {
        visited[data] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(data);

        while (!q.isEmpty()) {
            int num = q.poll(); //부모 노드

            List<Integer> list = graph.get(num);
            for (int i = 0; i < list.size(); i++) {
                int temp = list.get(i);
                if (!visited[temp]) {
                    parents[temp] = num;
                    q.offer(temp);
                    visited[temp] = true;
                }
            }
        }
    }

}
