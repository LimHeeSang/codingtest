package baekjoon.simulation;

import java.io.*;
import java.util.*;

public class Simulation1_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Node> q = new LinkedList<>();

        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                q.offer(new Node(j, Integer.parseInt(st.nextToken())));
            }

            int count = 0;
            int max;
            while (!q.isEmpty()) {
                max = 0;
                for (int k = 0; k < q.size(); k++) {
                    max = Math.max(max, q.get(k).important);
                }

                Node node = q.poll();
                if (node.important == max) {
                    count++;
                    if(node.index == m){
                        bw.write(count + "\n");
                        break;
                    }
                }else {
                    q.offer(node);
                }
            }
            q.clear();

        }
        bw.flush();
        bw.close();

    }

    static class Node{
        int index;
        int important;

        Node(int index, int important) {
            this.index = index;
            this.important = important;
        }
    }
}
