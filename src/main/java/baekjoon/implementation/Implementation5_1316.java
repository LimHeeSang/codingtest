package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implementation5_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        int answer = 0;
        for (String word : words) {
            if (isContinue(word)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean isContinue(String word) {
        String[] splited = word.split("");


        for (int i = 0; i < splited.length; i++) {
            String temp = splited[i];

            boolean check = false;
            for (int j = i + 1; j < splited.length; j++) {
                if (check && temp.equals(splited[j])) {
                    return false;
                }

                if (temp.equals(splited[j])) {
                    continue;
                } else {
                    check = true;
                }
            }
        }
        return true;
    }
}
