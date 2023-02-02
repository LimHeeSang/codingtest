package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Graph4_2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(a);


        while (true) {
            int preNum = list.get(list.size() - 1);
            String[] split = String.valueOf(preNum).split("");
            int[] arr = new int[split.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }

            int sum = 0;
            for (int num : arr) {
                sum += Math.pow(num, p);
            }

            if (!list.contains(sum)) {
                list.add(sum);
            } else {
                int index = list.indexOf(sum);
                System.out.println(index);
                break;
            }
        }
    }
}
