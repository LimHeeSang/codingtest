package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bruteforce9_1018 {
    //B = 0, W = 1
    static int B = 0;
    static int W = 1;
    static int answer = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] splited = br.readLine().split("");
            for (int j = 0; j < splited.length; j++) {
                if (splited[j].equals("B")) {
                    map[i][j] = B;
                } else {
                    map[i][j] = W;
                }
            }
        }

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                find(map, i, j);
            }
        }

        System.out.println(answer);
    }

    static void find(int[][] map, int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        int count = 0;

        int firstColor = map[x][y];

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (map[i][j] != firstColor) {
                    count++;
                }
                firstColor = changeColor(firstColor);
            }
            firstColor = changeColor(firstColor);
        }

        count = Math.min(count, 64 - count);
        answer = Math.min(answer, count);
    }

    static int changeColor(int color) {
        if (color == B) {
            return W;
        } else {
            return B;
        }
    }
}
