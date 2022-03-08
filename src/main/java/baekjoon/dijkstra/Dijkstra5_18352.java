package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra5_18352 {
    static final int INF = Integer.MAX_VALUE;

    static int n;
    static int m;

    static List<List<Node>> graph = new ArrayList<>();
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
            graph.get(a).add(new Node(b, 1));
        }

        visited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        dijkstra(new Node(start, 0));
        boolean check = false;
        for (int i = 1; i < n + 1; i++) {
            if(dist[i] == k) {
                check = true;
                System.out.println(i);
            }
        }
        if(!check) System.out.println(-1);

    }

    static void dijkstra(Node node) {
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<>(){
            public int compare(Node n1, Node n2) {
                return n1.cost - n2.cost;
            }
        });
        q.offer(node);
        dist[node.node] = 0;

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
