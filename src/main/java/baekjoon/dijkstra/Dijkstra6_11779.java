package baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra6_11779 {

    static final int INF = Integer.MAX_VALUE;

    static int n;
    static int m;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    static int[] previous;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[n + 1];
        previous = new int[n + 1];

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

        System.out.println(dijkstra(start, end));
        printPrevious(start, end);
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<>() {
            public int compare(Node n1, Node n2) {
                return n1.cost - n2.cost;
            }
        });
        q.offer(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            if(dist[curNode.idx] < curNode.cost) continue;

            for (Node nxtNode : graph.get(curNode.idx)) {
                if (dist[nxtNode.idx] > dist[curNode.idx] + nxtNode.cost) {
                    dist[nxtNode.idx] = dist[curNode.idx] + nxtNode.cost;
                    previous[nxtNode.idx] = curNode.idx;
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }

        return dist[end];
    }

    static void printPrevious(int start, int end) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(end);

        while (!dq.isEmpty()) {
            end = previous[end];
            if(start == end){
                dq.push(end);
                break;
            }
            dq.push(end);
        }

        System.out.println(dq.size());
        while (!dq.isEmpty()) {
            System.out.print(dq.pop() + " ");
        }

    }

    static class Node{
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
