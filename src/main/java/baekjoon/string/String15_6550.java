package baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class String15_6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while ((input = br.readLine()) != null) {
            String[] splited = input.split(" ");
            String s = splited[0];
            String t = splited[1];

            int sIndex = 0;
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == s.charAt(sIndex)) {
                    sIndex++;
                }
                if (sIndex == s.length()) {
                    break;
                }
            }
            if (sIndex == s.length()) {
                bw.write("Yes\n");
            } else {
                bw.write("No\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
