package baekjoon.bfs;
import java.util.*;
import java.io.*;

public class Bfs10_1303 {
    static int m;
    static int n;

    static final int W = 0;
    static final int B = 1;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int myTeamScore = 0;
        int enemyScore = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if(temp[j].equals("W")) graph[i][j] = W;
                else if(temp[j].equals("B")) graph[i][j] = B;
            }
        }

        //우리팀 전투력 측정 W
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && graph[i][j] == W){
                    myTeamScore += Math.pow(bfs(new Point(i, j), W), 2);
                }
            }
        }

        //상대팀 전투력 측정 B
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && graph[i][j] == B){
                    enemyScore += Math.pow(bfs(new Point(i, j), B), 2);
                }
            }
        }

        System.out.printf("%d %d", myTeamScore, enemyScore);

    }

    static int bfs(Point p, int color) {
        int count = 1;
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited[p.x][p.y] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = point.x + dx[i];
                int my = point.y + dy[i];

                if(mx < 0 || mx >= m || my < 0 || my >= n) continue;
                if (!visited[mx][my] && graph[mx][my] == color) {
                    q.offer(new Point(mx, my));
                    visited[mx][my] = true;
                    count++;
                }
            }
        }
        return count;
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
