package baekjoon.datastructure;

import java.io.*;
import java.util.*;

public class DataStructure5_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        List<Integer> result = new ArrayList<>();

        result.add(arr[k - 1]);
        arr[k - 1] = 0;
        int removeIdx = k - 1;

        while (result.size() != n) {
            //제거할 인덱스를 계산
            int temp = k;
            while (temp != 0) {
                removeIdx++;
                if (removeIdx >= n) {
                    removeIdx -= n;
                }
                if (arr[removeIdx] != 0) {
                    temp--;
                }
            }

            //result에 번호 저장
            result.add(arr[removeIdx]);

            //해당 result값 0으로 바꿈.
            arr[removeIdx] = 0;
        }

        bw.write("<");
        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(result.get(i)));
            if (i != n - 1) {
                bw.write(", ");
            }
        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
}
