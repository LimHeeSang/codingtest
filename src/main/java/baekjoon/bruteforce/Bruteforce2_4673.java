package baekjoon.bruteforce;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Bruteforce2_4673 {

    static boolean[] isSelf;
    static int n = 10000;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        isSelf = new boolean[n];


        for(int i=1; i<n; i++) {

            if(isSelf[i] == false) {
                calculate(i);
            }
        }


        for(int i=1; i<n; i++) {
            if(isSelf[i] == false) {
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();

    }

    static void calculate(int start) {

        int dn = start;
        while(start != 0) {
            dn += start % 10;
            start /= 10;
        }

        if(dn<n) {
            isSelf[dn] = true;
            calculate(dn);
        }else {
            return;
        }
    }
}