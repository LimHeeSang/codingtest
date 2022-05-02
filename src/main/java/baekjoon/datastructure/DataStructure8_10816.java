package baekjoon.datastructure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataStructure8_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        String[] splited = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(splited[i]);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        String[] splited2 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int answer = map.getOrDefault(Integer.parseInt(splited2[i]), 0);
            bw.write(answer + " ");
        }
        bw.flush();
        bw.close();

    }
}
