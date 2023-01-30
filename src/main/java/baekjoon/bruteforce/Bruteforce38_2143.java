package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bruteforce38_2143 {

    static List<Integer> listA = new ArrayList<>();
    static List<Integer> listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] split1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(split1[i]);
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        String[] split2 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(split2[i]);
        }

        calculateSum(a, listA);
        calculateSum(b, listB);
        Collections.sort(listB);

        long answer = 0;
        for (int sumA : listA) {
            int sumB = target - sumA;
            answer += (upperBound(listB, sumB) - lowerBound(listB, sumB));
        }
        System.out.println(answer);
    }

    static int lowerBound(List<Integer> list, int findNum) {
        int left = 0;
        int right = list.size();
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;

            if (list.get(mid) >= findNum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    static int upperBound(List<Integer> list, int findNum) {
        int left = 0;
        int right = list.size();
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;

            if (list.get(mid) <= findNum) {
                left = mid + 1;
            } else {    // list.get(mid) > findNum
                right = mid;
            }
        }
        return right;
    }

    static void calculateSum(int[] arr, List<Integer> list) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                list.add(sum);
            }
        }
    }
}
