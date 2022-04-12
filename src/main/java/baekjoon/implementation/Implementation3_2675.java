package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implementation3_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        String[] input = new String[t];

        for (int i = 0; i < t; i++) {
            input[i] = br.readLine();
        }

        for (int i = 0; i < t; i++) {
            calculate(input[i]);
        }
    }

    public static void calculate(String input) {
        String[] temp = input.split(" ");
        int n = Integer.parseInt(temp[0]);
        String s = temp[1];

        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < n; j++) {
                answer += s.charAt(i);
            }
        }
        System.out.println(answer);
    }
}
