package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DataStructure4_10845 {

    static final String PUSH = "push";
    static final String POP = "pop";
    static final String SIZE = "size";
    static final String EMPTY = "empty";
    static final String FRONT = "front";
    static final String BACK = "back";
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            if (temp.equals(PUSH)) {
                push(Integer.parseInt(st.nextToken()));
            }
            if (temp.equals(POP)) {
                pop();
            }
            if (temp.equals(SIZE)) {
                size();
            }
            if (temp.equals(EMPTY)) {
                empty();
            }
            if (temp.equals(FRONT)) {
                front();
            }
            if (temp.equals(BACK)) {
                back();
            }
        }
    }

    public static void push(int x) {
        dq.offer(x);
    }

    public static void pop() {
        if (dq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(dq.poll());
    }

    public static void size() {
        System.out.println(dq.size());
    }

    public static void empty() {
        if (dq.isEmpty()) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    public static void front() {
        if (dq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(dq.peekFirst());
    }

    public static void back() {
        if (dq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(dq.peekLast());
    }
}
