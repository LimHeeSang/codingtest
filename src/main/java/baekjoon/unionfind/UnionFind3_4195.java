package baekjoon.unionfind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UnionFind3_4195 {

    static int[] parent;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int f = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            parent = new int[f * 2];
            count = new int[f * 2];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            Arrays.fill(count, 1);

            int idx = 0;
            for (int i = 0; i < f; i++) {
                String s = br.readLine();
                String[] split = s.split(" ");
                String name1 = split[0];
                String name2 = split[1];

                if (!map.containsKey(name1)) {
                    map.put(name1, idx++);
                }
                if (!map.containsKey(name2)) {
                    map.put(name2, idx++);
                }

                unionParent(map.get(name1), map.get(name2));
                int result = count[findParent(map.get(name2))];
                bw.write(result + "\n");
            }
            map.clear();
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
            count[node2] += count[node1];
        } else if (node2 > node1) {
            parent[node2] = node1;
            count[node1] += count[node2];
        }
    }
}
