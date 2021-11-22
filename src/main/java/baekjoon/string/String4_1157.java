package baekjoon.string;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class String4_1157 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toUpperCase();
        int[] dp = new int[26];

        int index = 0;
        for(int i=0; i<str.length(); i++) {
            index = str.charAt(i) - 'A';
            dp[index]++;
        }


        int max = -1;
        char ch = '?';
        for(int i= 0; i<dp.length; i++) {
            if(dp[i] > max) {
                max = dp[i];
                ch = (char)(i+'A');
            }else if(max == dp[i]) {
                ch = '?';
            }
        }
        System.out.print(ch);
    }
}