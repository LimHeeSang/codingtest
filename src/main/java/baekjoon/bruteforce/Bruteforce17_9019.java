package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bruteforce17_9019 {

    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            visited = new int[10000];
            Arrays.fill(visited, Integer.MAX_VALUE);
            String result = bfs(start, end);
            System.out.println(result);
        }
    }

    static String bfs(int start, int end) {
        Queue<Operation> q = new LinkedList<>();
        q.offer(new Operation(start, ""));
        visited[start] = 0;

        while (!q.isEmpty()) {
            Operation curOp = q.poll();

            if (curOp.number == end) {
                return curOp.op;
            }

            int nextNum = d(curOp.number);
            if (visited[curOp.number] + 1 < visited[nextNum]) {
                visited[nextNum] = visited[curOp.number] + 1;
                q.offer(new Operation(nextNum, curOp.op + "D"));
            }

            nextNum = s(curOp.number);
            if (visited[curOp.number] + 1 < visited[nextNum]) {
                visited[nextNum] = visited[curOp.number] + 1;
                q.offer(new Operation(nextNum, curOp.op + "S"));
            }

            nextNum = l(curOp.number);
            if (visited[curOp.number] + 1 < visited[nextNum]) {
                visited[nextNum] = visited[curOp.number] + 1;
                q.offer(new Operation(nextNum, curOp.op + "L"));
            }

            nextNum = r(curOp.number);
            if (visited[curOp.number] + 1 < visited[nextNum]) {
                visited[nextNum] = visited[curOp.number] + 1;
                q.offer(new Operation(nextNum, curOp.op + "R"));
            }
        }
        return null;
    }

    private static int d(int n) {
        return (n * 2) % 10000;
    }

    private static int s(int n) {
        if (n == 0) {
            return 9999;
        }
        return n - 1;
    }

    private static int l(int n) {
        return (n % 1000) * 10 + n / 1000;
    }

    private static int r(int n) {
        return (n % 10) * 1000 + n / 10;
    }

    static class Operation {
        int number;
        String op;

        public Operation(int number, String op) {
            this.number = number;
            this.op = op;
        }
    }

}
