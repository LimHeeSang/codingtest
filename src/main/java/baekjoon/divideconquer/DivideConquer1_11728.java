package baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class DivideConquer1_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> result = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] splitN = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            result.add(Integer.parseInt(splitN[i]));
        }
        String[] splitM = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            result.add(Integer.parseInt(splitM[i]));
        }

        Collections.sort(result);
        for (int r : result) {
            bw.write(r + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
