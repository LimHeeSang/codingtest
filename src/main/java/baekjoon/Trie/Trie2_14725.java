package baekjoon.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Trie2_14725 {

    static Room root;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        root = new Room();

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int depth = Integer.parseInt(split[0]);

            Room curR = root;
            for (int j = 1; j < split.length; j++) {
                String food = split[j];
                if (!curR.nxtRooms.containsKey(food)) {
                    curR.nxtRooms.put(food, new Room());
                }
                curR = curR.nxtRooms.get(food);
            }
        }
        dfs(root, "");
        System.out.println(sb);
    }

    static void dfs(Room room, String bar) {
        for (String nxtRoom : room.nxtRooms.keySet()) {
            sb.append(bar).append(nxtRoom).append("\n");
            dfs(room.nxtRooms.get(nxtRoom), bar + "--");
        }
    }

    static class Room {
        Map<String, Room> nxtRooms = new TreeMap<>();
    }
}
