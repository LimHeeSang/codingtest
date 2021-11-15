package baekjoon.greedy;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Greedy3_11047 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[2];
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] moneys = new int[n];
        for(int i=0; i<n; i++) {
            moneys[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i= n-1; i>=0; i--) {
            if(moneys[i] <= k) {
                count += k/moneys[i];
                k = k % moneys[i];
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}