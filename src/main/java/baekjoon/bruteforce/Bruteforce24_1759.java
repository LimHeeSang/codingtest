package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Bruteforce24_1759 {

    static int l;
    static int c;
    static Set<String> set = new TreeSet<>();
    static char[] result;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        result = new char[l];
        arr = new char[c];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < c; i++) {
            arr[i] = split[i].charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, 0, 0, 0);
        for (String s : set) {
            System.out.println(s);
        }
    }

    static void dfs(int start, int depth, int aCount, int bCount) {
        if (depth == l) {
            if (aCount >= 1 && bCount >= 2) {
                StringBuilder sb = new StringBuilder();
                for (char r : result) {
                    sb.append(r);
                }
                set.add(sb.toString());
            }
            return;
        }

        for (int i = start; i < c; i++) {
            result[depth] = arr[i];
            if (isA(arr[i])) {
                dfs(i + 1, depth + 1, aCount + 1, bCount);
            } else {
                dfs(i + 1, depth + 1, aCount, bCount + 1);
            }
        }
    }

    static boolean isA(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
