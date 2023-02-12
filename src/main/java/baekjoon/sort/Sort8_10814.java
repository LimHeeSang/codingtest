package baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Sort8_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Member> list = new LinkedList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Member(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(list);
        for (Member m : list) {
            bw.write(m.age + " " + m.name + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static class Member implements Comparable<Member>{
        int id;
        int age;
        String name;

        public Member(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member member) {
            if (this.age == member.age) {
                return this.id - member.id;
            }
            return this.age - member.age;
        }
    }
}
