package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Stack2_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        char[] chars = s.toCharArray();

        Deque<Character> stack = new LinkedList<>();

        int answer = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            if (ch == '(') {
                stack.push(ch);
                continue;
            } else {
                stack.pop();
                if (chars[i - 1] == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
