package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Implementation7_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int average = 0;
        int mid = 0;
        int range = 0;

        for (int a : arr) {
            average += a;
        }
        average = (int) Math.round((double) average / n);

        Arrays.sort(arr);
        mid = arr[n / 2];

        range = arr[n - 1] - arr[0];

        int[] tempArr = new int[8001];

        for (int a : arr) {
            tempArr[a + 4000] += 1;
        }

        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int a : arr) {
            if (tempArr[a + 4000] > max) {
                max = tempArr[a + 4000];
            }
        }
        for (int a : arr) {
            if (tempArr[a + 4000] == max && !list.contains(a)) {
                list.add(a);
            }
        }

        System.out.println(average);
        System.out.println(mid);
        if (list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            System.out.println(list.get(1));
        }
        System.out.println(range);
    }
}
