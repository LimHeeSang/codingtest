package baekjoon.recursion;

import java.io.*;
import java.util.StringTokenizer;

public class Recursion1_14888 {

    static int n;
    static int m;
    static int[] arr;
    static int[] operator;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = n - 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operator = new int[4];    //덧셈, 뺄셈, 곱셈, 나눗셈
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int result, int idx) {
        if (idx == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) continue;

            operator[i] -= 1;
            if (i == 0) {
                dfs(result + arr[idx], idx + 1);
            } else if (i == 1) {
                dfs(result - arr[idx], idx + 1);
            } else if (i == 2) {
                dfs(result * arr[idx], idx + 1);
            } else if (i == 3) {
                if (result < 0) {
                    result *= (-1);
                    result /= arr[idx];
                    result *= (-1);
                }else{
                    result /= arr[idx];
                }
                dfs(result, idx + 1);
            }
            operator[i] += 1;
        }
    }
}
