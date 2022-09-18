package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DataStructure11_1021 {

    static LinkedList<Integer> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        String[] splited = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(splited[i]);
        }

        dq = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dq.offerLast(i);
        }

        int answer = 0;
        for (int num : arr) {
            if (dq.peekFirst() == num) {
                pollFirst();
                continue;
            }

            int index = dq.indexOf(num);
            int front = index;
            int back = dq.size() - 1 - index;

            if (front > back) {
                answer += moveRight(num);
            } else if (front <= back) {
                answer += moveLeft(num);
            }
        }

        System.out.println(answer);
    }

    public static int pollFirst() {
        return dq.pollFirst();
    }

    public static int moveLeft(int num) {
        int count = 0;
        while (dq.peekFirst() != num) {
            dq.offerLast(dq.pollFirst());
            count++;
        }
        pollFirst();
        return count;
    }

    public static int moveRight(int num) {
        int count = 0;
        while (dq.peekFirst() != num) {
            dq.offerFirst(dq.pollLast());
            count++;
        }
        pollFirst();
        return count;
    }
}
