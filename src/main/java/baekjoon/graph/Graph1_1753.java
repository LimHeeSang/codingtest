package baekjoon.graph;

import java.io.*;
import java.util.*;

public class Graph1_1753 {

    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        visited = new boolean[v + 1];
        dist = new int[v + 1];


        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph.get(S).add(new Node(E, W));
        }

        Arrays.fill(dist, INF);
        dijkstra(start);

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == INF) {
                bw.write("INF\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }

        bw.flush();
        bw.close();

    }

    static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((Node n1, Node n2) -> n1.weight - n2.weight);

        q.offer(new Node(start, 0));
        dist[start] = 0;
        visited[start] = true;

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            if(curNode.weight > dist[curNode.index]) continue;

            for (Node nxtNode : graph.get(curNode.index)) {
                if (dist[nxtNode.index] > curNode.weight + nxtNode.weight) {
                    dist[nxtNode.index] = curNode.weight + nxtNode.weight;
                    q.offer(new Node(nxtNode.index, dist[nxtNode.index]));
                }
            }

        }

    }

    static class Node {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}
