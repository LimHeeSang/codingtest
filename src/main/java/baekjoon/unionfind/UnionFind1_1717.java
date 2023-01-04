package baekjoon.unionfind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class UnionFind1_1717 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            int num = Integer.parseInt(split[0]);
            int node1 = Integer.parseInt(split[1]);
            int node2 = Integer.parseInt(split[2]);

            if (num == 0) {
                unionParent(node1, node2);
            } else if (num == 1) {
                if (isUnion(node1, node2)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
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

    static boolean isUnion(int node1, int node2) {
        return findParent(node1) == findParent(node2);
    }
}
