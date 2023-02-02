package note.graph;

import java.util.Arrays;

public class UnionFind {

    static int[] parent;
    static int cycleCount = 0;

    public static void main(String[] args) {
        int n = 9;  //노드는 1~9까지 존재
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        //간선 정보가 주어진다.
        // 노드다 한 집합인지 체크 여부는 순서에 영향을 받을 수 있으므로 parent 배열을 확인하는 것이 아니라, findParent 메소드를 사용하자.
        int[][] lines = {{8, 9}, {1, 2}, {2, 3} , {7, 4}, {5, 1}, {3, 5}, {4, 6}, {6, 7}};

        for (int[] line : lines) {
            unionParent(line[0], line[1]);
        }

        // 무방향 그래프에서 유니온 파인드로 싸이클 찾기
        System.out.println(cycleCount);
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
        } else if (node2 > node1) {
            parent[node2] = node1;
        } else {    // 부모가 같다면 싸이클이 발생
            cycleCount++;
        }
    }
}
