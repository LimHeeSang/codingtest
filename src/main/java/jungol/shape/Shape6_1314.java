package jungol.shape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Shape6_1314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char[][] result = new char[n][n];

        char alphabet = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //앞이 j, 뒤가 i
                if (i % 2 == 0) {
                    result[j][i] = alphabet++;
                }else {
                    result[n - 1 - j][i] = alphabet++;
                }

                if (alphabet > 'Z') {
                    alphabet = 'A';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
