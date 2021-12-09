package baekjoon.bruteforce;

import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;

public class Bruteforce4_2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = 0;


        for(int i = 0; i < n; i++) {

            int number = i;
            int dn = i;

            while(number != 0) {
                dn += number % 10;
                number /= 10;
            }

            if(dn == n) {
                result = i;
                break;
            }

        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }

}