package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class String8_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            calculate(s);
        }
    }

    public static void calculate(String s) {
        Deque<Character> dq = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!isSymbol(ch)) {
                continue;
            }

            if (dq.isEmpty()) {
                dq.offer(ch);
                continue;
            }

            if (isOppositeSymbol(dq.peekLast(), ch)) {
                dq.pollLast();
            } else {
                dq.offer(ch);
            }
        }

        if (dq.isEmpty()) {
            System.out.println("yes");
            return;
        }
        System.out.println("no");
    }

    public static boolean isSymbol(Character ch) {
        return ch == '(' || ch == ')' || ch == '[' || ch == ']';
    }

    public static boolean isOppositeSymbol(Character ch1, Character ch2) {
        if (ch1 == '(' && ch2 == ')') {
            return true;
        }
        if (ch1 == '[' && ch2 == ']') {
            return true;
        }
        return false;
    }
}
