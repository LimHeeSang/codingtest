package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Graph5_9446 {

    static int[] line;
    static boolean[] visited;
    static int[] parent;
    static boolean[] finished;
    static int cycleCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            line = new int[n + 1];
            parent = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];

            String[] s = br.readLine().split(" ");
            for (int i = 1; i < n + 1; i++) {
                line[i] = Integer.parseInt(s[i - 1]);
            }

            cycleCount = 0;
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    checkCycle(i);
                }
            }
            System.out.println(n - cycleCount);
        }
    }

    static void checkCycle(int curN) {
        visited[curN] = true;

        int nxtN = line[curN];
        if (!visited[nxtN]) {
            parent[nxtN] = curN;
            checkCycle(nxtN);
        } else if (!finished[nxtN]) {
            noteCycle(curN, nxtN);
        }

        finished[curN] = true;
    }

    static void noteCycle(int curN, int nxtN) {
        cycleCount++;
        if (curN == nxtN) {
            return;
        }

        noteCycle(parent[curN], nxtN);
    }
}
