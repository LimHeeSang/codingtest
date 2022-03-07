package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra3_1504 {

    static final int INF = Integer.MAX_VALUE;

    static int n;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] input1 = {1, v1, v2};
        int[] output1 = {v1, v2, n};
        int answer1 = answer(input1, output1);

        int[] input2 = {1, v2, v1};
        int[] output2 = {v2, v1, n};
        int answer2 = answer(input2, output2);

        int answer = Math.min(answer1, answer2);
        System.out.println(answer);
    }

    static int answer(int[] input, int[] output) {
        int answer = 0;

        for (int i = 0; i < 3; i++) {
            dijkstra(input[i]);
            if(dist[output[i]] == INF){
                answer = -1;
                break;
            }
            answer += dist[output[i]];
        }
        return answer;
    }

    static void dijkstra(int start) {
        Arrays.fill(dist, INF);
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
