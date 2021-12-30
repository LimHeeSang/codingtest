package baekjoon.tree;

import java.io.*;
import java.util.Arrays;

public class Tree5_5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        boolean check;

        for (int i = 0; i < t; i++) {
            check = false;
            int n = Integer.parseInt(br.readLine());

            String[] numbers = new String[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = br.readLine();
            }

            Arrays.sort(numbers);

            for (int k = 0; k < numbers.length-1; k++) {
                if (numbers[k+1].startsWith(numbers[k])) {
                    bw.write("NO\n");
                    check = true;
                    break;
                }
            }
            if (!check) {
                bw.write("YES\n");
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
