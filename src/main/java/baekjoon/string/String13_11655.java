package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String13_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();

        char[] alphabets = sentence.toCharArray();
        for (int i = 0; i < alphabets.length; i++) {
            if (Character.isLowerCase(alphabets[i])) {
                if (alphabets[i] + 13 > 'z') {
                    alphabets[i] = (char) ('a' + alphabets[i] - 'z' - 1);
                }
                alphabets[i] += 13;
            }
            if (Character.isUpperCase(alphabets[i])) {
                if (alphabets[i] + 13 > 'Z') {
                    alphabets[i] = (char) ('A' + alphabets[i] - 'Z' - 1);
                }
                alphabets[i] += 13;
            }
        }
        System.out.println(String.valueOf(alphabets));
    }
}
