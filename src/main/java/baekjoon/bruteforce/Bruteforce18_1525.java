package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Bruteforce18_1525 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                sb.append(s[j]);
            }
        }
        bfs(sb.toString());
        System.out.println(map.getOrDefault("123456780", -1));
    }

    static void bfs(String start) {
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        map.put(start, 0);

        while (!q.isEmpty()) {
            String curN = q.poll();
            int index = curN.indexOf('0');
            int x = index / 3;
            int y = index % 3;

            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];

                if (mx < 0 || mx >= 3 || my < 0 || my >= 3) {
                    continue;
                }
                int next = 3 * mx + my;
                StringBuilder sb = new StringBuilder(curN);
                sb.setCharAt(index, sb.charAt(next));
                sb.setCharAt(next, '0');

                String nxtString = sb.toString();
                if (!map.containsKey(nxtString)) {
                    q.offer(nxtString);
                    map.put(nxtString, map.get(curN) + 1);
                }
            }

        }
    }
}
