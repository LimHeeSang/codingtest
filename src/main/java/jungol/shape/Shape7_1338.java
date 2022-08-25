package jungol.shape;

import java.io.*;
import java.util.Arrays;

public class Shape7_1338 {

    static char[][] result;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        result = new char[n][n];

        Point prePoint = new Point(0, 0, 'A');
        for (int i = 0; i < n; i++) {
            prePoint = addDate(new Point(i, n - 1, prePoint.data));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == 0) {
                    bw.write(" " + " ");
                } else {
                    bw.write(result[i][j] + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static Point addDate(Point startPoint) {
        int x = startPoint.x;
        int y = startPoint.y;
        char data = startPoint.data;

        if (x < 0 || x >= n || y < 0 || y >= n) {
            if (data < 'A') {
                data = 'Z';
            }
            return new Point(x, y, data);
        }

        if (data > 'Z') {
            data = 'A';
        }

        result[x][y] = data;
        return addDate(new Point(x + 1, y - 1, (char) (data + 1)));
    }

    public static class Point {
        int x;
        int y;
        char data;

        public Point(int x, int y, char data) {
            this.x = x;
            this.y = y;
            this.data = data;
        }
    }
}
