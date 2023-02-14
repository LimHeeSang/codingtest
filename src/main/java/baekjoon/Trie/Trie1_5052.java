package baekjoon.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Trie1_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        loop : while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
            }

            Arrays.sort(words);

            boolean isEnd = false;
            for (int i = 0; i < words.length - 1; i++) {
                if (words[i + 1].startsWith(words[i])) {
                    System.out.println("NO");
                    isEnd = true;
                    break;
                }
            }

            if (!isEnd) {
                System.out.println("YES");
            }
        }
    }
}
