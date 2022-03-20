package baekjoon.simulation;

import java.io.*;
import java.util.StringTokenizer;

public class Simulation2_14719 {
    static int h;
    static int w;

    static int[][] block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());   //높이
        w = Integer.parseInt(st.nextToken());   //가로

        block = new int[h][w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int temp = Integer.parseInt(st.nextToken());
            for (int j = h - 1; j >= h - temp; j--) {
                block[j][i] = 1;
            }
        }

        int answer = 0;
        for (int i = h - 1; i >= 0; i--) {
            for (int j = 0; j < w; j++) {
                if (block[i][j] == 0 && isRain(i, j)) {
                    block[i][j] = 1;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean isRain(int x, int y) {
        //y가 양옆에 막혀있는지 체크
        boolean check1 = false;
        boolean check2 = false;
        for (int i = y; i >= 0; i--) {
            if (block[x][i] == 1) {
                check1 = true;
                break;
            }
        }
        for (int i = y; i < w; i++) {
            if (block[x][i] == 1) {
                check2 = true;
                break;
            }
        }

        return check1 && check2;
    }
}
