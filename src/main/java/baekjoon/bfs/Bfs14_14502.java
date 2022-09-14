package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bfs14_14502 {

    static final int BLANK = 0;
    static final int WALL = 1;
    static final int VIRUS = 2;

    static int answer = 0;

    static int n;
    static int m;
    static int[][] map;
    static int[][] copyMap;

    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copyMap = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] splited = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(splited[j]);
            }
        }

        makeWallThree(0);
        System.out.println(answer);
    }


    public static void makeWallThree(int countWall) {
        if (countWall == 3) {
            saveMap();

            spreadVirus();
            countSafeArea();

            beforeVirusMap();

            return;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == BLANK && !visited[i][j]) {
                    changeWall(i, j);
                    visited[i][j] = true;

                    makeWallThree(countWall + 1);

                    changeBlank(i, j);
                    visited[i][j] = false;
                }
            }
        }
    }



    private static void beforeVirusMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = copyMap[i][j];
            }
        }
    }

    private static void saveMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    private static void countSafeArea() {
        //map에서 0의 개수
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == BLANK) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }

    public static void spreadVirus() {
        //배열에서 2인 값을 찾아서 bfs()를 수행해준다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == VIRUS) {
                    bfs(i, j);
                }
            }
        }
    }

    public static void bfs(int initX, int initY) {
        //벽은 안되고, 빈칸만 퍼뜨릴 수 있다.
        //배열의 범위를 넘어서면 안된다.

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{initX, initY});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }

                if (map[mx][my] == BLANK) {
                    changeVirus(mx, my);
                    q.offer(new int[]{mx, my});
                }
            }
        }

    }


    public static void changeWall(int i, int j) {
        map[i][j] = WALL;
    }

    public static void changeVirus(int i, int j) {
        map[i][j] = VIRUS;
    }

    public static void changeBlank(int i, int j) {
        map[i][j] = BLANK;
    }

    //알고리즘 순서도
    //1. 벽을 3개 세운다.(조합, 0 -> 1) -> 벽을 되되돌리는 것 고려
    //2. 바이러스를 퍼트린다.(bfs, 2번인 거를 퍼트린다.)
    //3. 해당 상황에서 안전영역의 크기를 구한다.
    //4. 이전 상황에서의 안전영역의 크기와 비교해서 큰값으로 초기화 시켜준다.////
    //+  -> 바이러스를 다시 원래대로 되돌리는 것 고려
    //

}
