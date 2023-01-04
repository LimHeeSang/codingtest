package note.graph;

import java.util.Arrays;

public class UnionFind {

    static int[] parent;

    public static void main(String[] args) {
        int n = 9;  //노드는 1~9까지 존재
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        //간선 정보가 주어진다.
        int[][] lines = {{1, 2}, {3, 5}, {2, 3}, {4, 6}, {6, 7}, {8, 9}};

        for (int[] line : lines) {
            unionParent(line[0], line[1]);
        }

        System.out.println(Arrays.toString(parent));
    }

    static int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    static void unionParent(int node1, int node2) {
        node1 = findParent(node1);
        node2 = findParent(node2);
        if (node1 > node2) {
            parent[node1] = node2;
        } else {
            parent[node2] = node1;
        }
    }
}
