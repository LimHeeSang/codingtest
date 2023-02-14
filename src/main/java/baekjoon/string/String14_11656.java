package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class String14_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            result.add(word.substring(i));
        }

        Collections.sort(result);
        for (String r : result) {
            System.out.println(r);
        }
    }
}
