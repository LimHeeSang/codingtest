package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String7_11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int length = word.length();
        int start = 0;
        int end = 10;

        while (length >= 10) {
            System.out.println(word.substring(start, end));

            start = end;
            end += 10;

            length -= 10;
        }
        System.out.println(word.substring(start, start + length));
    }
}
