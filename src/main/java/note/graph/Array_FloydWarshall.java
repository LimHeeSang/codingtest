package note.graph;

import java.util.Arrays;

public class Array_FloydWarshall {
    static int n = 4;
    static final int INF = 1000000;

    public static void main(String[] args) {
        int[][] graph = {
                {0, 5, INF, 8},
                {7, 0, 9, INF},
                {2, INF, 0, 4},
                {INF, INF, 3, 0}
        };

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(graph));

    }
}
