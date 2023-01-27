package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Bruteforce34_1208 {

    static int n;
    static int s;
    static int[] arr;
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        dfs(0, n / 2, 0, list1);
        dfs(n / 2, n, 0, list2);
        Collections.sort(list1);
        Collections.sort(list2);

        long answer = twoPointer();
        System.out.println(s == 0 ? answer - 1 : answer);
    }

    static void dfs(int depth, int end, int sum, List<Integer> list) {
        if (depth == end) {
            list.add(sum);
            return;
        }

        dfs(depth + 1, end, sum, list);
        dfs(depth + 1, end, sum + arr[depth], list);
    }

    static long twoPointer() {
        int left = 0;
        int right = list2.size() - 1;
        long count = 0;

        while (left < list1.size() && right >= 0) {
            int sum = list1.get(left) + list2.get(right);

            if (sum == s) {
                int leftValue = list1.get(left);
                int count1 = 0;
                while (left < list1.size() && list1.get(left) == leftValue) {
                    left++;
                    count1++;
                }

                int rightValue = list2.get(right);
                int count2 = 0;
                while (right >= 0 && list2.get(right) == rightValue) {
                    right--;
                    count2++;
                }
                count += (long) count1 * count2;

            } else if (sum > s) {
                right--;
            } else {    // sum < s
                left++;
            }
        }
        return count;
    }
}
