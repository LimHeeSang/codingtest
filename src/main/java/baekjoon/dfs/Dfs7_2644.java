package baekjoon.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Dfs7_2644 {
    static int answer = 0;
    static int end;

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(start, 0);

        if (answer == 0) {
            bw.write("-1");
        }else {
            bw.write(String.valueOf(answer));
        }
        bw.flush();
        bw.close();

    }

    static void dfs(int start, int count) {
        if(start == end){
            answer = count;
            return;
        }

        visited[start] = true;

        for (int i : graph.get(start)) {
            if (!visited[i]) {
                dfs(i, count + 1);
            }
        }

    }
}
