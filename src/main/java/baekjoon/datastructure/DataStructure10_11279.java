package baekjoon.datastructure;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DataStructure10_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue((Comparator<Integer>) (o1, o2) -> o2 - o1);


        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                pq.offer(num);
            } else {
                if (pq.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
