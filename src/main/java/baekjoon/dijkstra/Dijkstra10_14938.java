package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra10_14938 {

    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int[] itemCount = new int[n + 1];
        String[] splited = br.readLine().split(" ");
        for (int i = 1; i < n + 1; i++) {
            itemCount[i] = Integer.parseInt(splited[i - 1]);
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(new Node(i, 0));

            int count = 0;
            for (int j = 1; j < n + 1; j++) {
                if (dist[j] <= m) {
                    count += itemCount[j];
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    static void dijkstra(Node start) {
        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        q.offer(start);
        dist[start.idx] = 0;

        while (!q.isEmpty()) {
            Node curP = q.poll();

            if (dist[curP.idx] < curP.cost) {
                continue;
            }

            for (Node nxtN : graph.get(curP.idx)) {
                if (dist[nxtN.idx] > dist[curP.idx] + nxtN.cost) {
                    dist[nxtN.idx] = dist[curP.idx] + nxtN.cost;
                    q.offer(new Node(nxtN.idx, dist[nxtN.idx]));
                }
            }
        }
    }

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
