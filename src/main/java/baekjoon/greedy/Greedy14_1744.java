package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Greedy14_1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 1) {
                positive.add(arr[i]);
            } else if (arr[i] <= 0) {
                negative.add(arr[i]);
            } else if (arr[i] == 1) {
                answer++;
            }
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);

        for (int i = 0; i < positive.size(); i += 2) {
            if (i == positive.size() - 1) {
                answer += positive.get(i);
                break;
            }
            answer += (positive.get(i) * positive.get(i + 1));
        }

        for (int i = 0; i < negative.size(); i+=2) {
            if (i == negative.size() - 1) {
                answer += negative.get(i);
                break;
            }
            answer += (negative.get(i) * negative.get(i + 1));
        }

        System.out.println(answer);
    }
}
