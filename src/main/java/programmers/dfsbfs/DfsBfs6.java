package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 아이템 줍기
 */
public class DfsBfs6 {

    int[][] map = new int[101][101];
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[0].length; j++) {
                rectangle[i][j] *= 2;
            }
        }
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        for (int i = 0; i < rectangle.length; i++) {
            drawLine(rectangle, rectangle[i]);
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(characterX, characterY));
        map[characterX][characterY] = 0;

        while (!q.isEmpty()) {
            Point curP = q.poll();

            for (int i = 0; i < 4; i++) {
                int mx = curP.x + dx[i];
                int my = curP.y + dy[i];

                if (mx < 0 || mx >= 101 || my < 0 || my >= 101) {
                    continue;
                }

                if (map[mx][my] == 1) {
                    map[mx][my] = map[curP.x][curP.y] + 1;
                    q.offer(new Point(mx, my));
                }
            }
        }

        System.out.println(map[itemX][itemY]);
        return map[itemX][itemY] / 2;
    }

    void drawLine(int[][] rectangle, int[] spot){
        Point leftDown = new Point(spot[0], spot[1]);
        Point rightUp = new Point(spot[2], spot[3]);

        drawUp(rectangle, leftDown, rightUp);
        drawDown(rectangle, rightUp, leftDown);
    }

    void drawUp(int[][] rectangle, Point leftDown, Point rightUp){
        for(int i = leftDown.x; i <= rightUp.x; i++){
            if(!isRectangleArea(rectangle, i, leftDown.y)){
                map[i][leftDown.y] = 1;
            }
        }
        for(int i = leftDown.y; i <= rightUp.y; i++){
            if(!isRectangleArea(rectangle, leftDown.x, i)){
                map[leftDown.x][i] = 1;
            }
        }
    }

    void drawDown(int[][] rectangle, Point rightUp, Point leftDown){
        for(int i = rightUp.x; i >= leftDown.x; i--){
            if(!isRectangleArea(rectangle, i, rightUp.y)){
                map[i][rightUp.y] = 1;
            }
        }
        for(int i = rightUp.y; i >= leftDown.y; i--){
            if(!isRectangleArea(rectangle, rightUp.x, i)){
                map[rightUp.x][i] = 1;
            }
        }
    }

    boolean isRectangleArea(int[][] rectangle, int x, int y){
        for(int i = 0; i < rectangle.length; i++){
            int[] spots = rectangle[i];
            if(x > spots[0] && x < spots[2] && y > spots[1] && y < spots[3]){
                return true;
            }
        }
        return false;
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
