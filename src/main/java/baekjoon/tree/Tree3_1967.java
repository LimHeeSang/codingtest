package baekjoon.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Tree3_1967 {

    static List<List<Node>> graph;
    static boolean[] visited;
    static int maxLen = 0;
    static int maxNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int a, b, c;
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        dfs(1, 0);
        Arrays.fill(visited, false);
        maxLen = 0;
        dfs(maxNode, 0);
        System.out.println(maxLen);

    }

    static class Node {
        int data;
        int len;

        Node(int data, int len) {
            this.data = data;
            this.len = len;
        }
    }

    static void dfs(int data, int tempLen) {
        visited[data] = true;
        List<Node> list = graph.get(data);

        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);

            if (!visited[node.data]) {
                dfs(node.data, tempLen+node.len);
            }
        }
        if (maxLen < tempLen) {
            maxLen = tempLen;
            maxNode = data;
        }

    }

}
