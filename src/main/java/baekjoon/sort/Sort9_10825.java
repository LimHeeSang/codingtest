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

public class Sort9_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Student> students = new LinkedList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            students.add(new Student(
                            st.nextToken(),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())));
        }

        Collections.sort(students);
        for (Student student : students) {
            bw.write(student.name + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Student implements Comparable<Student> {
        String name;
        int koreanScore;
        int englishScore;
        int mathScore;

        public Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        @Override
        public int compareTo(Student student) {
            if (this.koreanScore == student.koreanScore) {
                if (this.englishScore == student.englishScore) {
                    if (this.mathScore == student.mathScore) {
                        return this.name.compareTo(student.name);
                    }
                    return student.mathScore - this.mathScore;
                }
                return this.englishScore - student.englishScore;
            }
            return student.koreanScore - this.koreanScore;
        }
    }
}
