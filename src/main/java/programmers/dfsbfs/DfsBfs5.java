package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임 맵 최단거리
 */
public class DfsBfs5 {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n;
    int m;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        bfs(maps, new Point(0, 0));
        if(maps[n - 1][m - 1] == 1){
            return -1;
        }
        return maps[n - 1][m - 1];
    }

    void bfs(int[][] maps, Point start){
        Queue<Point> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            Point curP = q.poll();

            for(int i = 0; i < 4; i++){
                int mx = curP.x + dx[i];
                int my = curP.y + dy[i];

                if(mx < 0 || mx >= n || my < 0 || my >= m){
                    continue;
                }

                if(maps[mx][my] == 1){
                    q.offer(new Point(mx, my));
                    maps[mx][my] = maps[curP.x][curP.y] + 1;
                }
            }
        }

    }

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

