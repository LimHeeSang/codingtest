package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Stack3_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String word = br.readLine();
            System.out.println(isVPS(word));
        }
    }

    static String isVPS(String word) {
        char[] words = word.toCharArray();
        Deque<Character> dq = new ArrayDeque<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i] == '(') {
                dq.push(words[i]);
            } else {
                if (!dq.isEmpty() && dq.peekLast() == '(') {
                    dq.pop();
                } else {
                    dq.push(words[i]);
                }
            }
        }
        return dq.size() == 0 ? "YES" : "NO";
    }
}
