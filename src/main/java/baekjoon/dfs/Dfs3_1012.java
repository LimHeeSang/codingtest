package baekjoon.dfs;

import java.io.*;
        import java.util.Arrays;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.StringTokenizer;

public class Dfs3_1012 {

    static int t;
    static int m;
    static int n;
    static int k;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int count;
    static List<Integer> countBox = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        int x, y;

        StringTokenizer st;
        StringTokenizer st2;

        for(int i=0; i<t; i++){

            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visited = new boolean[n][m];

            for(int j=0; j<k; j++){
                st2 = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st2.nextToken());
                y = Integer.parseInt(st2.nextToken());

                map[y][x] = 1;
            }

            for(int a=0; a<n; a++){
                for(int b=0; b<m; b++){
                    if(map[a][b] == 1 && visited[a][b] == false){
                        Point point = new Point(a, b);
                        dfs(point);
                        count++;
                    }
                }
            }

            for(int m=0; m<map.length; m++){
                Arrays.fill(map[m], 0);
            }
            for(int n=0; n<visited.length; n++){
                Arrays.fill(visited[n], false);
            }

            countBox.add(count);
            count = 0;

        }

        for(int v=0; v<countBox.size(); v++){
            bw.write(countBox.get(v) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(Point point) {
        visited[point.x][point.y] = true;

        for(int i=0; i<4; i++){
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<m){
                if(map[nx][ny] == 1 && visited[nx][ny] == false){
                    Point nPoint = new Point(nx, ny);
                    dfs(nPoint);
                }

            }
        }

    }

    static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}