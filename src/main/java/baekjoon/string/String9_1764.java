package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class String9_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new LinkedHashSet<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (set.contains(s)) {
                result.add(s);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (String r : result) {
            System.out.println(r);
        }
    }
}
