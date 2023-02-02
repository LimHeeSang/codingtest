package baekjoon.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class UnionFind4_11724 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            unionParent(start, end);
        }

        Set<Integer> result = new HashSet<>();
        for (int i = 1; i < n + 1; i++) {
            result.add(findParent(i));
        }
        System.out.println(result.size());
    }

    static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    static void unionParent(int n1, int n2) {
        n1 = findParent(n1);
        n2 = findParent(n2);
        if (n1 > n2) {
            parent[n1] = n2;
        } else if (n2 > n1) {
            parent[n2] = n1;
        }
    }
}
