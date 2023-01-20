package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Bruteforce22_3108 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        List<Rectangle> rectangles = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            rectangles.add(new Rectangle(x1, y1, x2, y2));
        }

        for (int i = 0; i < n; i++) {
            Rectangle r1 = rectangles.get(i);
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                Rectangle r2 = rectangles.get(j);
                if (isDuplicate(r1, r2)) {
                    unionParent(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (Integer p : parent) {
            set.add(findParent(parent[p]));
        }
        int answer = set.size();
        for (Rectangle r : rectangles) {
            if (isStartZero(r.x1, r.y1, r.x2, r.y2)) {
                answer--;
                break;
            }
        }
        System.out.println(answer);
    }

    static boolean isStartZero(int x1, int y1, int x2, int y2) {
        if (x1 <= 0 && 0 <= x2 && (y1 == 0 || y2 == 0)) {
            return true;
        }
        if (y1 <= 0 && 0 <= y2 && (x1 == 0 || x2 == 0)) {
            return true;
        }
        return false;
    }

    static boolean isDuplicate(Rectangle r1, Rectangle r2) {
        if(r1.x1 < r2.x1 && r2.x2 < r1.x2 && r1.y1 < r2.y1 && r2.y2 < r1.y2) {
            return false;
        }
        if(r2.x1 < r1.x1 && r1.x2 < r2.x2 && r2.y1 < r1.y1 && r1.y2 < r2.y2) {
            return false;
        }
        if(r1.x2 < r2.x1 || r1.y2 < r2.y1 || r2.x2 < r1.x1 || r2.y2 <r1.y1) {
            return false;
        }
        return true;
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
        } else if (n2 > n1) {
            parent[n2] = n1;
        }
    }

    static class Rectangle {
        int x1;
        int y1;
        int x2;
        int y2;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}
