package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Bruteforce37_2143 {

    static List<Integer> listA = new ArrayList<>();
    static List<Integer> listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] brr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }

        calculateSum(arr, listA, target);
        calculateSum(brr, listB, target);
        Collections.sort(listA);
        Collections.sort(listB);

        int left = 0;
        int right = listB.size() - 1;
        int sum;
        long count = 0;

        while (left < listA.size() && right >= 0) {
            sum = listA.get(left) + listB.get(right);

            if (sum == target) {
                int count1 = 0;
                int leftValue = listA.get(left);
                while (left < listA.size() && leftValue == listA.get(left)) {
                    count1++;
                    left++;
                }

                int count2 = 0;
                int rightValue = listB.get(right);
                while (right >= 0 && rightValue == listB.get(right)) {
                    count2++;
                    right--;
                }
                count += (long) count1 * count2;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(count);
    }

    static void calculateSum(int[] arr, List<Integer> list, int target) {
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            list.add(a);
            int sum = a;
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                list.add(sum);
            }
        }
    }
}
