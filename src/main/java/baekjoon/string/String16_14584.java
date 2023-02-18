package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String16_14584 {

    static String cryptoSentence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cryptoSentence = br.readLine();

        int n = Integer.parseInt(br.readLine());
        String[] dict = new String[n];
        for (int i = 0; i < n; i++) {
            dict[i] = br.readLine();
        }

        char[] chars = cryptoSentence.toCharArray();

        for (int i = 0; i < 26; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] + 1 > 'z') {
                    chars[j] = 'a';
                } else {
                    chars[j]++;
                }
            }
            for (int j = 0; j < chars.length; j++) {
                sb.append(Character.valueOf(chars[j]));
            }
            String result = sb.toString();
            for (String d : dict) {
                if (result.contains(d)) {
                    System.out.println(result);
                    return;
                }
            }
        }
    }
}
