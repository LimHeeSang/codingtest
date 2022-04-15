package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy7_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
            b.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(a);
        Collections.sort(b, Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += (a.get(i) * b.get(i));
        }

        System.out.println(answer);
    }
}
