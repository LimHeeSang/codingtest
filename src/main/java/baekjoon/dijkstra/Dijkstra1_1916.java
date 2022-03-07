package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra1_1916 {

    static final int INF = Integer.MAX_VALUE;
    static int n;
    static int m;

    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

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

        Arrays.fill(dist, INF);
        dijkstra(start);
        System.out.println(dist[end]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<>(){
            public int compare(Node n1, Node n2) {
                return n1.cost - n2.cost;
            }
        });

        q.offer(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            if(dist[curNode.node] < curNode.cost) continue;

            for (Node nxtNode : graph.get(curNode.node)) {
                if (dist[nxtNode.node] > curNode.cost + nxtNode.cost) {
                    dist[nxtNode.node] = curNode.cost + nxtNode.cost;
                    q.offer(new Node(nxtNode.node, dist[nxtNode.node]));
                }
            }
        }
    }

    static class Node{
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
