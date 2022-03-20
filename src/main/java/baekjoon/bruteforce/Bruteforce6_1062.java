package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bruteforce6_1062 {
    static int n;
    static int k;
    static String[] words;
    static boolean[] dict = new boolean[26];

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = parsing(br.readLine());
        }
        dict['a' - 'a'] = true;
        dict['c' - 'a'] = true;
        dict['i' - 'a'] = true;
        dict['n' - 'a'] = true;
        dict['t' - 'a'] = true;

        k -= 5;
        dfs(k, 0);
        System.out.println(answer);
    }

    static void dfs(int k, int start) {
        if (k == 0) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                String temp = words[i];
                boolean isRead = true;
                for (int j = 0; j < temp.length(); j++) {
                    if (!dict[temp.charAt(j) - 'a']) {
                        isRead = false;
                        break;
                    }
                }
                if(isRead){
                    count++;
                }
            }
            answer = Math.max(answer, count);
            return;
        }

        for (int i = start; i < dict.length; i++) {
            if (!dict[i]) {
                dict[i] = true;
                dfs(k - 1, i + 1);
                dict[i] = false;
            }
        }
    }

    private static String parsing(String str) {
        int lastIdx = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 't') {
                lastIdx = i;
                break;
            }
        }
        return str.substring(4, lastIdx);
    }
}
