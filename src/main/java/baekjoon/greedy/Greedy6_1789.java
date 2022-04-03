package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy6_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());

        long num = 0;
        long i = 1;

        long count = 0;
        while (num != s) {
            if(num == s) break;
            if(num > s) {
                count--;
                break;
            }
            num += i;
            i++;
            count++;
        }

        System.out.println(count);
    }
}
