package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Dfs4_11724 {

    static List<List<Integer>> graph = new LinkedList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        visited[0] = true;

        for(int i=0; i<n+1; i++) {
            List<Integer> list = new LinkedList<>();

            graph.add(list);
        }

        int u, v;

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        int count =0;
        for(int i=0; i<n+1; i++) {
            if(visited[i] == false) {
                dfs(i);
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }

    static void dfs(int start) {
        visited[start] = true;

        List<Integer> list = graph.get(start);
        for(int i=0; i<list.size(); i++) {
            int temp = list.get(i);

            if(visited[temp] == false) {
                dfs(temp);
            }
        }

    }

}