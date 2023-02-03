package note.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 방향 그래프와 무방향 그래프에서의 싸이크 판별
// 1. 해당 그래프가 싸이클인지 판별할 수 있어야 한다.
// 2. 해당 그래프에서 싸이클의 개수를 알 수 있어야 한다.
// 3. 싸이클이 발생하는 노드들을 알 수 있어야 한다.
// 4. 싸이클이 발생하는 노드의 집합을 구분할 수 있어야 한다.
public class Cycle {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static boolean[] finished;
    static int[] cycle; // 사이클 여부와 사이클 집합 표현 하는 배열
    static int[] parent;
    static int cycleCount = 0;

    public static void main(String[] args) {
        int n = 19;
        visited = new boolean[n];
        finished = new boolean[n];
        cycle = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] lines = {
                {4, 7}, {7, 6}, {2, 6}, {5, 6}, {3, 4}, {1, 2}, {1, 5}, {2, 3}, {6, 4}, {4, 2},
                {10, 8}, {8, 9}, {11, 9}, {9, 9},
                {13, 12}, {12, 14}, {14, 13}, {14, 15}, {15, 16}, {14, 16}, {16, 18}, {18, 17}, {17, 16}
        };


        for (int[] line : lines) {
            graph.get(line[0]).add(line[1]);
        }

        // isCycle 메소드 예제
        /*int count = 0;
        for (int i = 1; i < n; i++) {
            Arrays.fill(visited, false);
            if (isCycle(i, i)) {
                System.out.println(i + "는 사이클 이다.");
                count++;
            } else {
                System.out.println(i + "는 사이클이 아니다.");
            }
        }
        System.out.println(count);*/

        advancedCheckCycle(1);
        System.out.println(Arrays.toString(cycle));
    }

    // 일반적인 알고리즘 모든 정점에 대하여 DFS 수행하여 자기 자신으로 돌아오는지 확인하여, 돌아온다면 사이클이 존재한다.
    // 시간 복잡도는 O(V(V+E)) 로 TL을 받게 될 확률이 높다.
    static boolean checkCycle(int startN, int curN) {
        if (visited[curN]) {
            return startN == curN;
        }

        visited[curN] = true;
        for (int nxtN : graph.get(curN)) {
            if (checkCycle(startN, nxtN)) {
                return true;
            }
        }
        return false;
    }

    static void advancedCheckCycle(int curN) {

        visited[curN] = true;
        for (int nxtN : graph.get(curN)) {
            if (!visited[nxtN]) {
                parent[nxtN] = curN;
                advancedCheckCycle(nxtN);
            } else if (!finished[nxtN]) {
                cycleCount++;
                noteCycle(curN, nxtN);
            }
        }

        finished[curN] = true;
    }

    // 어느 한 정점의 부모가 하나일 때만 가능하다.
    static void noteCycle(int curN, int nxtN) {
        cycle[curN] = cycleCount;

        if (curN == nxtN) {
            return;
        }

        noteCycle(parent[curN], nxtN);
    }
}
// https://hongl.tistory.com/60
// https://hy38.github.io/posts/finding-cycles-in-graph/
// https://m.blog.naver.com/PostView.nhn?blogId=jh20s&logNo=221248815321&proxyReferer=https:%2F%2Fwww.google.com%2F
// https://code0xff.tistory.com/39?category=723759