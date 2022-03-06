package baekjoon.dfs;

import java.io.*;
import java.util.*;

public class Dfs10_16953 {
    static long a;
    static long b;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        dfs(a, 1);
        if(min == Long.MAX_VALUE) min = -1;
        System.out.println(min);
    }

    static void dfs(long x, int count) {
        if(x >= b) {
            if(x == b) min = Math.min(count, min);
            return;
        }

        dfs(div(x), count + 1);

        dfs(concat(x), count + 1);

    }

    static long div(long x) {
        return x * 2;
    }

    static long concat(long x) {
        String temp = String.valueOf(x);
        temp += "1";
        return Long.parseLong(temp);
    }
}
