package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Greedy10_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        Arrays.sort(split, Collections.reverseOrder());

        long sum = 0;
        for (int i = 0; i < split.length; i++) {
            sum += Integer.parseInt(split[i]);
        }
        if (!split[split.length - 1].equals("0") || !(sum % 3 == 0)) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]);
        }
        System.out.println(sb);
    }
}
