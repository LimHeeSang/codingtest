package baekjoon.dfs;

import java.io.*;
import java.util.*;

public class Dfs5_2583 {
    static int m;
    static int n;
    static int k;

    static int width;

    static List<Integer> list = new ArrayList<>();
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[m][n];

        int fx, fy;
        int bx, by;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            fx = Integer.parseInt(st.nextToken());
            fy = Integer.parseInt(st.nextToken());
            bx = Integer.parseInt(st.nextToken());
            by = Integer.parseInt(st.nextToken());
            draw(fx, fy, bx, by);
        }

        //false인 부분 dfs로 탐색 후 리스트에 넓이 담기(넓이는 depth횟수와 같음)
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    width = 1;
                    dfs(new Point(i, j));
                    list.add(width);
                    count++;
                }
            }
        }

        bw.write(count + "\n");
        Collections.sort(list);
        for (int l : list) {
            bw.write(l + " ");
        }
        bw.flush();
        bw.close();

    }

    static void draw(int fx, int fy, int bx, int by) {  //직사각형 그리는 함수
        fy = m - fy;
        by = m - by;

        int y = bx - fx;
        int x = fy - by;
        for (int i = by; i < fy; i++) {
            for (int j = fx; j < bx; j++) {
                visited[i][j] = true;
            }
        }
    }

    static void dfs(Point start) {
        visited[start.x][start.y] = true;

        for (int i = 0; i < 4; i++) {
            int mx = start.x + dx[i];
            int my = start.y + dy[i];

            if(mx < 0 || mx >= m || my < 0 || my >= n) continue;
            if (!visited[mx][my]) {
                dfs(new Point(mx, my));
                width++;
            }
        }
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
