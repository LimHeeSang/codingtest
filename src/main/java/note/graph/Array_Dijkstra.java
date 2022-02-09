package note.graph;

import java.util.Arrays;

public class Array_Dijkstra {

    static int n = 6;
    static final int INF = 100000;
    static int[][] graph;
    static boolean[] visited = new boolean[n];
    static int[] dist = new int[n];

    public static void main(String[] args) {

        graph = new int[][]{
                {0, 2, 5, 1, INF, INF},
                {2, 0, 3, 2, INF, INF},
                {5, 3, 0, 3, 1, 5},
                {1, 2, 3, 0, 1, INF},
                {INF, INF, 1, 1, 0, 2},
                {INF, INF, 5, INF, 2, 0}
        };

        Arrays.fill(dist, INF);

        dijkstra(0);
        System.out.println(Arrays.toString(dist));
    }

    public static void dijkstra(int start){
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int current = findSmallNode();
            visited[current] = true;
            for (int j = 0; j < n; j++) {
                if(!visited[j] && dist[current] + graph[current][j] < dist[j]){
                    dist[j] = dist[current] + graph[current][j];
                }
            }
        }

    }

    public static int findSmallNode() {
        int min = INF;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] < min && !visited[i]) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }

}
