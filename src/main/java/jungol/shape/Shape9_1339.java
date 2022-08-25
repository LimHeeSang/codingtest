package jungol.shape;

import java.io.*;

public class Shape9_1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] result = new char[n][n];
        char alphabet = 'A';

        for (int i = n / 2; i >= 0; i--) {

            for (int j = i; j < n - i; j++) {
                result[j][i] = alphabet++;
                if (alphabet > 'Z') {
                    alphabet = 'A';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == 0) {
                    bw.write(" " + " ");
                } else {
                    bw.write(result[i][j] + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
