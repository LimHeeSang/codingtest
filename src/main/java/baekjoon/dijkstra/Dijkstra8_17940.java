package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra8_17940 {

    static int[] change;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    static int[] count;
    static final int INF = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken()) + 1;

        change = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            change[i] = Integer.parseInt(br.readLine());
        }

        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = Integer.parseInt(split[j - 1]);
            }
        }

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (map[i][j] > 0) {
                    graph.get(i).add(new Node(j, map[i][j], 0));
                }
            }
        }

        dist = new int[n + 1];
        count = new int[n + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(count, INF);
        int start = 1;
        dijkstra(start);

        bw.write(count[end] + " " + dist[end]);
        bw.flush();
        br.close();
        bw.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (n1, n2) -> {
                    if (n1.count == n2.count) {
                        return n1.time - n2.time;
                    }
                    return n1.count - n2.count;
                }
        );

        pq.offer(new Node(start, 0, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            List<Node> nxtNodes = graph.get(curNode.index);
            for (Node nxtNode : nxtNodes) {
                int nxtChange = calculateNextChange(curNode, nxtNode);

                if (curNode.count > dist[curNode.index]) {
                    continue;
                }

                if (curNode.count + nxtChange < count[nxtNode.index]) {
                    count[nxtNode.index] = curNode.count + nxtChange;
                    dist[nxtNode.index] = curNode.time + nxtNode.time;
                    pq.offer(new Node(nxtNode.index, dist[nxtNode.index], count[nxtNode.index]));
                } else if (curNode.count + nxtChange == count[nxtNode.index]) {
                    if (curNode.time + nxtNode.time < dist[nxtNode.index]) {
                        dist[nxtNode.index] = curNode.time + nxtNode.time;
                        pq.offer(new Node(nxtNode.index, dist[nxtNode.index], count[nxtNode.index]));
                    }
                }
            }
        }
    }

    static int calculateNextChange(Node curNode, Node nxtNode) {
        if (change[curNode.index] == change[nxtNode.index]) {
            return 0;
        }
        return 1;
    }

    static class Node{
        int index;
        int time;
        int count;

        public Node(int index, int time, int count) {
            this.index = index;
            this.time = time;
            this.count = count;
        }
    }
}
