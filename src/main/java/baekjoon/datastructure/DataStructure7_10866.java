package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class DataStructure7_10866 {

    static final String PUSH_FRONT = "push_front";
    static final String PUSH_BACK = "push_back";
    static final String POP_FRONT = "pop_front";
    static final String POP_BACK = "pop_back";
    static final String SIZE = "size";
    static final String EMPTY = "empty";
    static final String FRONT = "front";
    static final String BACK = "back";

    static final Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            String temp = st.nextToken();
            if (temp.equals(PUSH_BACK)) {
                pushBack(Integer.parseInt(st.nextToken()));
            }
            if (temp.equals(PUSH_FRONT)) {
                pushFront(Integer.parseInt(st.nextToken()));
            }
            if (temp.equals(POP_FRONT)) {
                popFront();
            }
            if (temp.equals(POP_BACK)) {
                popBack();
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

    public static void pushFront(int x) {
        dq.offerFirst(x);
    }

    public static void pushBack(int x) {
        dq.offerLast(x);
    }

    public static void popFront() {
        if (dq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(dq.pollFirst());
    }

    public static void popBack() {
        if (dq.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(dq.pollLast());
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
