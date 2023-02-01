package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy9_2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int woman = Integer.parseInt(st.nextToken());
        int man = Integer.parseInt(st.nextToken());
        int internship = Integer.parseInt(st.nextToken());

        int team = 0;
        while (woman >= 2 && man >= 1) {
            woman -=2;
            man -= 1;
            team++;
        }
        internship -= man;
        internship -= woman;

        if (internship > 0) {
            if (internship % 3 == 0) {
                team -= internship / 3;
            } else {
                team -= (internship / 3) + 1;
            }
        }
        System.out.println(team);
    }
}
