package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Sort10_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new TreeMap<>((o1, o2) -> o1.compareTo(o2));

        for (int i = 0; i < n; i++) {
            long card = Long.parseLong(br.readLine());
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        long max = 0;
        for (long card : map.values()) {
            max = Math.max(max, card);
        }

        Set<Map.Entry<Long, Integer>> entrys = map.entrySet();
        for (Map.Entry<Long, Integer> entry : entrys) {
            if (max == entry.getValue()) {
                System.out.println(entry.getKey());
                return;
            }
        }

    }
}
