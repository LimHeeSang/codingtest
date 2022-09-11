package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Implementation9_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] arr = new int[10];

        String[] numbers = s.split("");
        int[] numbersInt = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersInt[i] = Integer.parseInt(numbers[i]);
        }

        for (int num : numbersInt) {
            //6 또는 9이면 arr6, 9 값중 최솟값을 1 증가
            if (num == 6 || num == 9) {
                int min = Math.min(arr[6], arr[9]);
                if (arr[6] == min) {
                    arr[6]++;
                } else {
                    arr[9]++;
                }
            } else {
                arr[num]++;
            }
        }

        int answer = 0;
        for (int a : arr) {
            answer = Math.max(answer, a);
        }
        System.out.println(answer);
    }
}
