package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Bruteforce36_2632 {

    static int target;
    static int m;
    static int n;
    static int[] a;
    static int[] b;
    static List<Integer> pizzaA = new ArrayList<>();
    static List<Integer> pizzaB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        a = new int[m];
        b = new int[n];
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            boolean[] visited = new boolean[m];
            visited[i] = true;
            addSum(a, pizzaA, visited, i, i + 1, a[i]);
        }
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            addSum(b, pizzaB, visited, i, i + 1, b[i]);
        }

        pizzaA.add(0);
        pizzaB.add(0);
        Collections.sort(pizzaA);
        Collections.sort(pizzaB);

        int left = 0;
        int right = pizzaB.size() - 1;
        long answer = 0;
        int sum;
        while (left < pizzaA.size() && right >= 0) {
            sum = pizzaA.get(left) + pizzaB.get(right);

            if (sum == target) {
                int count1 = 0;
                int leftValue = pizzaA.get(left);
                while (left < pizzaA.size() && leftValue == pizzaA.get(left)) {
                    count1++;
                    left++;
                }

                int count2 = 0;
                int rightValue = pizzaB.get(right);
                while (right >= 0 && rightValue == pizzaB.get(right)) {
                    count2++;
                    right--;
                }

                answer += (long) count1 * count2;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(answer);
    }

    static void addSum(int[] pizza, List<Integer> result, boolean[] visited, int startIdx, int nowIdx, int sum) {
        if (nowIdx == pizza.length) {
            nowIdx = 0;
        }

        result.add(sum);
        if (!visited[nowIdx] && sum <= target && nowIdx != startIdx - 1) {
            visited[nowIdx] = true;
            addSum(pizza, result, visited, startIdx, nowIdx + 1, sum + pizza[nowIdx]);
        }
    }
}
