package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Implementation8_15686 {

    static int n;
    static int m;
    static int[][] map; //0 빈칸, 1 집, 2 치킨집
    static int minChickenDist = Integer.MAX_VALUE;
    static List<Point> chickenPoints = new ArrayList<>();
    static List<Point> combPoints = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] splited = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(splited[j]);
            }
        }

        saveChickenPoints();
        initMap();
        for (int i = 1; i <= m; i++) {
            dfs(0, 0, i);
        }
        System.out.println(minChickenDist);
    }

    //치킨 좌표를 모두 0으로 초기화
    public static void initMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }
    }

    //한 집의 치킨거리를 계산한는 메소드
    public static int calculateChickenDist(Point point1, Point point2) {
        return Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y);
    }

    //치킨집의 좌표 저장
    public static void saveChickenPoints() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    chickenPoints.add(new Point(i, j));
                }
            }
        }
    }

    public static void dfs(int depth, int start, int x) {
        if (depth == x) {
            calculateStreetChickenDist();
            return;
        }

        for (int i = start; i < chickenPoints.size(); i++) {
            Point point = chickenPoints.get(i);
            combPoints.add(point);
            dfs(depth + 1, i + 1, x);
            combPoints.remove(point);
        }
    }

    //현재 맵 상황에서 도시의 치킨 거리 계산 = 각 집의 치킨거리 의 총합
    public static void calculateStreetChickenDist() {

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    int chickenDist = Integer.MAX_VALUE;
                    for (Point cPoint : combPoints) {
                        chickenDist = Math.min(chickenDist, calculateChickenDist(new Point(i, j), cPoint));
                    }
                    sum += chickenDist;
                }
            }
        }
        minChickenDist = Math.min(minChickenDist, sum);

    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}