package baekjoon.bfs;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.util.*;

public class Bfs2_2667 {

    static int n;
    static int [][] map;
    static boolean [][] visited;
    static int count;
    static List<Integer> list = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for(int i=1; i<n+1; i++) {
            String[] str = br.readLine().split("");

            for(int j=1; j<n+1; j++) {
                map[i][j] = Integer.parseInt(str[j-1]);
            }
        }


        int totalCount = 0;

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(map[i][j] == 1 && visited[i][j] == false) {
                    dfs(i, j);
                    totalCount++;
                }
            }
        }

        Collections.sort(list);

        bw.write(totalCount + "\n");
        for(int i=0; i<list.size(); i++) {
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
        bw.close();

    }

    static void dfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;

        int count = 1;

        while(!q.isEmpty()) {
            Point point = q.poll();

            for(int i=0; i<4; i++) {

                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx>0 && nx<n+1 && ny>0 && ny<n+1) {
                    if(map[nx][ny] == 1 && visited[nx][ny] == false) {
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                        count++;
                    }
                }
            }

        }
        list.add(count);

    }


    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}