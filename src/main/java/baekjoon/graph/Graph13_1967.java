package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Graph13_1967 {

    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int maxNode = 0;
    static int maxValue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }

        visited = new boolean[n + 1];
        dfs(new Node(1, 0));

        maxValue = 0;
        visited = new boolean[n + 1];
        dfs(new Node(maxNode, 0));

        System.out.println(maxValue);
    }

    static void dfs(Node curN) {
        if (maxValue < curN.cost) {
            maxValue = curN.cost;
            maxNode = curN.value;
        }

        visited[curN.value] = true;
        for (Node nxtN : graph.get(curN.value)) {
            if (!visited[nxtN.value]) {
                dfs(new Node(nxtN.value, curN.cost + nxtN.cost));
            }
        }
    }

    static class Node {
        int value;
        int cost;

        public Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }
    }
}
