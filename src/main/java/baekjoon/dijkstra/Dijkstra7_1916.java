package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra7_1916 {

    static int n;
    static int m;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist(start);
        System.out.println(dist[end]);
    }

    static void dist(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        q.offer(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            if (dist[curNode.node] < curNode.cost) {
                continue;
            }
            for (Node nxtNode : graph.get(curNode.node)) {
                if (dist[nxtNode.node] > dist[curNode.node] + nxtNode.cost) {
                    dist[nxtNode.node] = dist[curNode.node] + nxtNode.cost;
                    q.offer(new Node(nxtNode.node, dist[nxtNode.node]));
                }
            }
        }
    }

    static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
