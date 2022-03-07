package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra2_1238 {

    static final int INF = Integer.MAX_VALUE;

    static List<List<Node>> graph = new ArrayList<>();
    static List<List<Node>> reverseGraph = new ArrayList<>();
    static int[] dist1; //파티장 -> 집
    static int[] dist2; //파티장 <- 집


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        dist1 = new int[n + 1];
        dist2 = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            reverseGraph.get(b).add(new Node(a, c));
        }

        Arrays.fill(dist1, INF);
        dijkstra(x, dist1, graph);

        Arrays.fill(dist2, INF);
        dijkstra(x, dist2, reverseGraph);

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            answer = Math.max(answer, dist1[i] + dist2[i]);
        }

        System.out.println(answer);
    }

    static void dijkstra(int start, int[] dist, List<List<Node>> graph) {   //파티장 -> 집가는데 각자 학생잉 걸리는 최장 시간 저장
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<>(){
            public int compare(Node n1, Node n2) {
                return n1.time - n2.time;
            }
        });

        q.offer(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            if(dist[curNode.node] < curNode.time) continue;

            for (Node nxtNode : graph.get(curNode.node)) {
                if (dist[nxtNode.node] > curNode.time + nxtNode.time) {
                    dist[nxtNode.node] = curNode.time + nxtNode.time;
                    q.offer(new Node(nxtNode.node, dist[nxtNode.node]));
                }
            }
        }
    }

    static class Node{
        int node;
        int time;

        public Node(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
}
