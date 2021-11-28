package baekjoon.bfs;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.StringTokenizer;

public class Bfs1_2178 {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];

        for(int i=1; i<n+1; i++) {
            String[] str = br.readLine().split("");

            for(int j=1; j<m+1; j++)
                graph[i][j] = Integer.parseInt(str[j-1]);
        }


        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1}; // 왼쪽, 오른쪽, 위, 아래

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(1, 1));
        visited[1][1] = true;

        while(!q.isEmpty()) {

            Point point = q.poll();

            for(int i=0; i<4; i++) {

                int mx = point.x + dx[i];
                int my = point.y + dy[i];
                if(mx>0 && mx<m+1 && my>0 && my<n+1) {

                    if(graph[my][mx] != 0 && visited[my][mx]==false) {
                        visited[my][mx] = true;
                        graph[my][mx] = graph[point.y][point.x] + 1;
                        q.offer(new Point(mx, my));
                    }
                }
            }
        }
        bw.write(String.valueOf(graph[n][m]));
        bw.flush();
        bw.close();

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