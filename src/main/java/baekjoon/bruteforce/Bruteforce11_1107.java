package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bruteforce11_1107 {

    static int n;
    static int answer;
    static boolean[] isFixButton;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        answer = Math.abs(n - 100);
        isFixButton = new boolean[10];
        if (m != 0) {
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                int num = Integer.parseInt(s[i]);
                isFixButton[num] = true;
            }
            //true 이면 고장난 버튼
        }

        String[] split = String.valueOf(n).split("");
        for (int i = 0; i < 999999; i++) {
            String str = String.valueOf(i);
            boolean isPressFixButton = false;
            for (int j = 0; j < str.length(); j++) {
                if (isFixButton[str.charAt(j) - '0']) {
                    isPressFixButton = true;
                }
            }
            if (!isPressFixButton) {
                answer = Math.min(answer, Math.abs(n - i) + str.length());
            }
        }

        System.out.println(answer);
    }
}
