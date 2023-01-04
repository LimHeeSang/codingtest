package programmers.greedy;

import java.util.Arrays;

/**
 * 섬 연결하기
 */
public class Greedy3 {

    int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        Arrays.sort(costs, (cost1, cost2) -> cost1[2] - cost2[2]);

        for(int[] cost : costs) {
            int node1 = cost[0];
            int node2 = cost[1];
            int costValue = cost[2];

            if(findParent(node1) != findParent(node2)) {
                answer += costValue;
                unionParent(node1, node2);
            }
        }
        return answer;
    }

    int findParent(int node) {
        if(parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    void unionParent(int node1, int node2) {
        node1 = findParent(node1);
        node2 = findParent(node2);
        if(node1 > node2) {
            parent[node1] = node2;
        }else{
            parent[node2] = node1;
        }
    }
}
