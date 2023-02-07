package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Graph12_1167 {

    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) {
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                graph.get(start).add(new Node(end, cost));
            }
        }

        visited = new boolean[v + 1];
        distance = new int[v + 1];

        dfs(new Node(1, 0));
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 2; i < v + 1; i++) {
            if (maxValue < distance[i]) {
                maxIndex = i;
                maxValue = distance[i];
            }
        }

        visited = new boolean[v + 1];
        distance = new int[v + 1];
        dfs(new Node(maxIndex, 0));
        int answer = 0;
        for (int i = 1; i < v + 1; i++) {
            answer = Math.max(answer, distance[i]);
        }
        System.out.println(answer);
    }

    static void dfs(Node node) {
        visited[node.data] = true;

        for (Node nxtNode : graph.get(node.data)) {
            if (!visited[nxtNode.data]) {
                distance[nxtNode.data] = node.cost + nxtNode.cost;
                dfs(new Node(nxtNode.data, distance[nxtNode.data]));
            }
        }
    }

    static class Node {
        int data;
        int cost;

        public Node(int data, int cost) {
            this.data = data;
            this.cost = cost;
        }
    }
}
