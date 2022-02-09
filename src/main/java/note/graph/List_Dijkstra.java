package note.graph;

import java.util.*;

public class List_Dijkstra {

    static int n = 6;
    static final int INF = 100000;
    static int[][] example;

    static List<List<Node>> graph = new ArrayList<>();
    //static boolean[] visited = new boolean[n+1];
    static int[] dist = new int[n+1];

    public static void main(String[] args) {

        example = new int[][]{
                {1, 2, 2},
                {1, 3, 5},
                {1, 4, 1},

                {2, 1, 2},
                {2, 3, 3},
                {2, 4, 2},

                {3, 1, 5},
                {3, 2, 3},
                {3, 4, 3},
                {3, 5, 1},
                {3, 6, 5},

                {4, 1, 1},
                {4, 2, 2},
                {4, 3, 3},
                {4, 5, 1},

                {5, 3, 1},
                {5, 4, 1},
                {5, 6, 2},

                {6, 3, 5},
                {6, 5, 2}
        };

        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<example.length; i++){
            graph.get(example[i][0]).add(new Node(example[i][1], example[i][2]));
        }

        Arrays.fill(dist, INF);

        dijkstra(1);
        System.out.println(Arrays.toString(dist));
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        q.offer(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            if(dist[curNode.idx] < curNode.cost) continue;
            for (Node nxtNode : graph.get(curNode.idx)) {
                if (dist[nxtNode.idx] > curNode.cost + nxtNode.cost) {
                    dist[nxtNode.idx] = curNode.cost + nxtNode.cost;
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }


    }

    static class Node{
        int idx;
        int cost;
        Node(int node, int edge){
            this.idx = node;
            this.cost = edge;
        }
    }

}


