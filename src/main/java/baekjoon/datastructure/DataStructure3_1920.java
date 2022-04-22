package baekjoon.datastructure;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class DataStructure3_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(s[i]));
        }

        int m = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            if (set.contains(Integer.parseInt(s1[i]))) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 +  "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
