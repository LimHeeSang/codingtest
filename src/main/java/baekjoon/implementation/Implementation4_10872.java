package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implementation4_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = 1;
        for (int i = n; i > 0; i--) {
            answer *= i;
        }
        System.out.println(answer);
    }
}
