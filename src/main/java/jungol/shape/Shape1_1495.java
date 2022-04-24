package jungol.shape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Shape1_1495 {

    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        map[0][0] = 1;
        Info nowInfo = new Info(0, 0, 1);

        int count = 0;
        while (map[n - 1][n - 1] == 0) {
            if (count % 4 == 0) {
                if (isPosRight(nowInfo.x + 1, nowInfo.y)) {
                    nowInfo = downOne(nowInfo);
                } else {
                    nowInfo = rightOne(nowInfo);
                }
            }
            if (count % 4 == 1) {
                nowInfo = upRight(nowInfo);
            }
            if (count % 4 == 2) {
                if (isPosRight(nowInfo.x, nowInfo.y + 1)) {
                    nowInfo = rightOne(nowInfo);
                } else {
                    nowInfo = downOne(nowInfo);
                }
            }
            if (count % 4 == 3) {
                nowInfo = downLeft(nowInfo);
            }
            count++;
        }

        System.out.println(Arrays.deepToString(map));
    }

    static boolean isPosRight(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static Info downOne(Info info) {
        int nextX = info.x + 1;
        int nextY = info.y;
        int nextData = info.data + 1;

        map[nextX][nextY] = nextData;
        return new Info(nextX, nextY, nextData);
    }

    static Info rightOne(Info info) {
        int nextX = info.x;
        int nextY = info.y + 1;
        int nextData = info.data + 1;

        map[nextX][nextY] = nextData;
        return new Info(nextX, nextY, nextData);
    }

    static Info upRight(Info info) {
        int nowX = info.x;
        int nowY = info.y;
        int nowData = info.data;

        while (true) {
            if (nowX - 1 < 0 || nowY + 1 >= n) {
                break;
            }
            nowX -= 1;
            nowY += 1;
            nowData += 1;
            map[nowX][nowY] = nowData;
        }

        return new Info(nowX, nowY, nowData);
    }

    static Info downLeft(Info info) {
        int nowX = info.x;
        int nowY = info.y;
        int nowData = info.data;

        while (true) {
            if (nowX + 1 >= n || nowY - 1 < 0) {
                break;
            }
            nowX += 1;
            nowY -= 1;
            nowData += 1;
            map[nowX][nowY] = nowData;
        }

        return new Info(nowX, nowY, nowData);
    }

    static class Info {
        int x;
        int y;
        int data;

        public Info(int x, int y, int data) {
            this.x = x;
            this.y = y;
            this.data = data;
        }
    }
}
