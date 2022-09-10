package baekjoon.string;

import java.io.*;

public class String10_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        int[] alphabetCount = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            alphabetCount[ch - 'a'] += 1;
        }

        for (int alphabet : alphabetCount) {
            bw.write(alphabet + " ");
        }
        bw.flush();
        bw.close();
    }
}
