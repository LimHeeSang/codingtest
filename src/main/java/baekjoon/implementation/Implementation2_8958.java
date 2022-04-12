package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implementation2_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            calculate(answer[i]);
        }
    }

    public static void calculate(String s) {
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'O') {
                temp += 1;
            } else {
                temp = 0;
            }
            sum += temp;
        }
        System.out.println(sum);
    }
}
