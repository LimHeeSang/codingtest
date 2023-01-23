package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bruteforce27_6603 {

    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }

            String[] split = s.split(" ");
            int k = Integer.parseInt(split[0]);
            int[] arr = new int[k];
            int[] result = new int[6];
            for (int i = 1; i < split.length; i++) {
                arr[i - 1] = Integer.parseInt(split[i]);
            }

            dfs(arr, result, 0, 0);
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int[] arr, int[] result, int depth, int start) throws IOException {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < arr.length; i++) {
            result[depth] = arr[i];
            dfs(arr, result, depth + 1, i + 1);
        }
    }
}
