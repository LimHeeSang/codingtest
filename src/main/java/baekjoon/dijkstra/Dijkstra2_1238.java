package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra2_1238 {

    static final int INF = Integer.MAX_VALUE;

    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist; //파티장 -> 집
    static int[] temp; //파티장 -> 집
    static int[] result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        temp = new int[n + 1];
        result = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        Arrays.fill(dist, INF);
        dijkstra(x, dist);

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(temp, INF);
            dijkstra(i, temp);
            result[i] = temp[x];
        }

        for (int i = 1; i < n + 1; i++) {
            result[i] += dist[i];
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            if (answer < result[i]) {
                answer = result[i];
            }
        }

        System.out.println(answer);
    }

    static void dijkstra(int start, int[] dist) {   //파티장 -> 집가는데 각자 학생잉 걸리는 최장 시간 저장
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
