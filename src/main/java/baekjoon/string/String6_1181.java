package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class String6_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                return o1.compareTo(o2);
            }
        });

        String temp = "";
        for (String s : list) {
            if (temp.equals(s)) {
                continue;
            }
            temp = s;
            System.out.println(s);
        }
    }
}
