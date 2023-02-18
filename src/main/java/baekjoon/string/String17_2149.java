package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class String17_2149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String plainKey = br.readLine();
        String cipherText = br.readLine();

        int n = cipherText.length() / plainKey.length() + 1;
        int m = plainKey.length();

        String[][] cipherArr = new String[n][m];
        String[][] plainArr = new String[n][m];
        String[] plainKeySplit = plainKey.split("");
        String[] cipherTextSplit = cipherText.split("");
        boolean[] keyVisited = new boolean[m];

        for (int i = 0; i < m; i++) {
            plainArr[0][i] = plainKeySplit[i];
        }
        Arrays.sort(plainKeySplit);
        for (int i = 0; i < m; i++) {
            cipherArr[0][i] = plainKeySplit[i];
        }

        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cipherArr[j][i] = cipherTextSplit[idx++];
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (cipherArr[0][j] == plainArr[0][i] && !keyVisited[j]) {
                    keyVisited[j] = true;
                    for (int k = 1; k < n; k++) {
                        plainArr[k][i] = cipherArr[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(plainArr[i][j]);
            }
        }
        System.out.println(sb);
    }
}
