package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

public class Implementation10_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int q = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            while (q-- > 0) {
                String[] split = br.readLine().split(" ");
                String operator = split[0];
                int data = Integer.parseInt(split[1]);

                if (operator.equals("I")) {
                    map.put(data, map.getOrDefault(data, 0) + 1);
                }
                if (operator.equals("D") && data == 1 && !map.isEmpty()) {
                    Integer lastKey = map.lastKey();
                    if (map.get(lastKey) == 1) {
                        map.remove(lastKey);
                    } else {
                        map.put(lastKey, map.get(lastKey) - 1);
                    }
                }
                if (operator.equals("D") && data == -1 && !map.isEmpty()) {
                    Integer firstKey = map.firstKey();
                    if (map.get(firstKey) == 1) {
                        map.remove(firstKey);
                    } else {
                        map.put(firstKey, map.get(firstKey) - 1);
                    }
                }
            }

            if (map.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
