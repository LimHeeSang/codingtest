package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class DataStructure1_10828 {

    static final String PUSH = "push";
    static final String POP = "pop";
    static final String SIZE = "size";
    static final String EMPTY = "empty";
    static final String TOP = "top";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = 0;
            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            if (command.equals(PUSH)) {
                push(dq, num);
            }
            if (command.equals(POP)) {
                pop(dq);
            }
            if (command.equals(SIZE)) {
                size(dq);
            }
            if (command.equals(EMPTY)) {
                empty(dq);
            }
            if (command.equals(TOP)) {
                top(dq);
            }
        }
    }

    public static void push(Deque<Integer> dq, int num) {
        dq.addLast(num);
    }

    public static void pop(Deque<Integer> dq) {
        if (dq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(dq.pollLast());
    }

    public static void size(Deque<Integer> dq) {
        System.out.println(dq.size());
    }

    public static void empty(Deque<Integer> dq) {
        if (dq.isEmpty()) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    public static void top(Deque<Integer> dq) {
        if (dq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(dq.peekLast());
    }
}
