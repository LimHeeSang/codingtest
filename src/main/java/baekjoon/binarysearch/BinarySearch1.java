package baekjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BinarySearch1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int m = Integer.parseInt(br.readLine());

            String[] str;
            if (m <= 10) {
                str = br.readLine().split(" ");
            }else{
                int count = 0;
                String temp = "";

                if(m % 10 == 0) count = m / 10;
                else count = m / 10 + 1;
                for (int j = 0; j < count; j++) {
                    temp += br.readLine();
                    temp += " ";
                }
                str = temp.split(" ");
            }

            int[] arr = new int[m];
            for (int j = 0; j < m; j++) {
                arr[j] = Integer.parseInt(str[j]);
            }

            operation(arr);
        }
    }

    static void operation(int[] arr) {
        int m = arr.length;

        List<Integer> list = new LinkedList<>();
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            int idx = Collections.binarySearch(list, arr[i]);
            if(idx < 0){
                idx *= (-1);
                idx -= 1;
            }else{
                idx += 1;
            }
            list.add(idx, arr[i]);

            if (i % 2 == 0) {
                result.add(list.get(i / 2));
            }
        }

        printResult(result);
    }

    static void printResult(List<Integer> result) {
        //결과 result 출력
        int size = result.size();
        System.out.println(size);

        if (size <= 10) {
            for (int i = 0; i < size; i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }else{
            int count = 0;

            if (size % 10 == 0) count = size / 10;
            else count = size / 10 + 1;

            for (int i = 0; i < size; i++) {
                System.out.print(result.get(i) + " ");
                if(i != 0 && i%9 == 0) System.out.println();
            }
            System.out.println();
        }
    }

}