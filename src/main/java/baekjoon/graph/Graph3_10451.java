package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Graph3_10451 {

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];

            String[] s = br.readLine().split(" ");
            for (int i = 1; i < n + 1; i++) {
                arr[i] = Integer.parseInt(s[i - 1]);
            }

            int answer = 0;
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (isCycle(i, i)) {
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static boolean isCycle(int start, int curNode) {
        if (start == arr[curNode]) {
            return true;
        }

        if (!visited[arr[curNode]]) {
            visited[arr[curNode]] = true;
            return isCycle(start, arr[curNode]);
        }
        return false;
    }
}
