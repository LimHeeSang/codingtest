package jungol.shape;

import java.io.*;
import java.util.StringTokenizer;

public class Shape2_1303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 1;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                bw.write(count++ + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
