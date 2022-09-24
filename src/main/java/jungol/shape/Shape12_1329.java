package jungol.shape;

import java.io.*;

public class Shape12_1329 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int start = 1;
        int m = 1;
        while (start != n) {
            start += 2;
            m += 3;
        }
        char[][] result = new char[n][m];

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < i + 2*i+1; j++) {
                result[i][j] = '*';
            }
        }
        for (int i = n / 2; i < n; i++) {
            for (int j = n - 1 - i; j < n-1-i + 2*(n-1-i)+1; j++) {
                result[i][j] = '*';
            }
        }



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == 0) {
                    bw.write(" ");
                } else {
                    bw.write(String.valueOf(result[i][j]));
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
