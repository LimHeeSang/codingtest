package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Bruteforce19_2251 {

    static int[] limit;
    static int[] box;
    static Set<String> result = new HashSet<>();
    static Set<Integer> answer = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        limit = new int[3];
        box = new int[3];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(split[i]);
        }
        box[2] = limit[2];

        bfs();
        for (int num : answer) {
            bw.write(num + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[] start = {0, 0, box[2]};
        q.offer(start);
        result.add("0" + "0" + box[2]);
        answer.add(box[2]);

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    //cur의 i에서 j로 물을 옮긴다.
                    if (cur[i] == 0 || i == j) {
                        continue;
                    }

                    int[] move = Arrays.copyOf(cur, 3);
                    if (limit[j] - move[j] > 0) {
                        int canMove = limit[j] - move[j];
                        if (move[i] < canMove) {
                            move[j] += move[i];
                            move[i] -= move[i];
                        } else if (move[i] >= canMove) {
                            move[j] += canMove;
                            move[i] -= canMove;
                        }
                    }

                    String sum = String.valueOf(move[0]) + String.valueOf(move[1]) + String.valueOf(move[2]);
                    if (!result.contains(sum)) {
                        q.offer(move);
                        result.add(sum);
                        if (move[0] == 0) {
                            answer.add(move[2]);
                        }
                    }

                }
            }

        }
    }
}
