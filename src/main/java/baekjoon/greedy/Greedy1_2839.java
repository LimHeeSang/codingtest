package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Greedy1_2839{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        while(true) {

            if(n%5 == 0) {
                count += n/5;
                bw.write(String.valueOf(count));
                break;
            }
            n -= 3;
            count++;

            if(n<0) {
                bw.write(String.valueOf(-1));
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
