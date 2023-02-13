package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Stack4_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char[] words = word.toCharArray();
        Deque<Character> dq = new ArrayDeque<>();

        int count = 0;
        char preWord = '0';
        for (int i = 0; i < words.length; i++) {
            if (words[i] == '(') {
                dq.push(words[i]);
            } else {
                if (preWord == '(') {
                    dq.pop();
                    count += dq.size();
                } else {
                    dq.pop();
                    count++;
                }
            }
            preWord = words[i];
        }
        System.out.println(count);
    }
}
