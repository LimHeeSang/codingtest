package baekjoon.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bruteforce8_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Person> personList = new ArrayList<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            String[] splited = br.readLine().split(" ");
            personList.add(new Person(Integer.parseInt(splited[0]), Integer.parseInt(splited[1])));
        }

        for (int i = 0; i < n; i++) {
            Person person = personList.get(i);

            int count = 0;
            for (int j = 0; j < n; j++) {

                Person tempPerson = personList.get(j);
                if (person.isBigger(tempPerson)) {
                    count++;
                }
            }
            result[i] = count + 1;
        }

        for (int r : result) {
            bw.write(r + " ");
        }
        bw.flush();
        bw.close();
    }

    public static class Person {
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public boolean isBigger(Person person) {
            if (weight < person.weight && height < person.height) {
                return true;
            }
            return false;
        }
    }
}
