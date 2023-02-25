package baekjoon.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UnionFind5_1043 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        String[] split = br.readLine().split(" ");
        int[] knowTruthPerson = new int[split.length - 1];
        for (int i = 1; i < split.length; i++) {
            knowTruthPerson[i - 1] = Integer.parseInt(split[i]);
        }

        // 진실을 아는 사람 한 집합으로 표현하기 (0으로)
        for (int person : knowTruthPerson) {
            unionParent(0, person);
        }

        List<int[]> partys = new ArrayList<>();
        while (m-- > 0) {
            String[] splited = br.readLine().split(" ");
            int[] partyPersons = new int[Integer.parseInt(splited[0])];
            for (int i = 1; i < splited.length; i++) {
                partyPersons[i - 1] = Integer.parseInt(splited[i]);
            }

            for (int i = 0; i < partyPersons.length - 1; i++) {
                unionParent(partyPersons[i], partyPersons[i + 1]);
            }
            partys.add(partyPersons);
        }

        int answer = 0;
        loop : for (int[] party : partys) {
            for (int person : party) {
                if (findParent(person) == 0) {
                    continue loop;
                }
            }
            answer++;
        }

        System.out.println(answer);
    }

    static int findParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    static void unionParent(int n1, int n2) {
        n1 = findParent(n1);
        n2 = findParent(n2);

        if (n1 > n2) {
            parent[n1] = n2;
        } else if (n1 < n2) {
            parent[n2] = n1;
        }
    }

}
