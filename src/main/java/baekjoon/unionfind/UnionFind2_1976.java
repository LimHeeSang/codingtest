package baekjoon.unionfind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UnionFind2_1976 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            for (int j = 0; j < split.length; j++) {
                if (Integer.parseInt(split[j]) == 1) {
                    unionParent(i + 1, j + 1);
                }
            }
        }

        String s = br.readLine();
        String[] split = s.split(" ");
        int[] path = new int[split.length];
        for (int i = 0; i < path.length; i++) {
            path[i] = Integer.parseInt(split[i]);
        }

        if (isUnion(path)) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }
        bw.flush();
        br.close();
        bw.close();
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

    static boolean isUnion(int[] path) {
        int pre = parent[path[0]];
        for (int i = 1; i < path.length; i++) {
            if (pre != parent[path[i]]) {
                return false;
            }
        }
        return true;
    }
}
