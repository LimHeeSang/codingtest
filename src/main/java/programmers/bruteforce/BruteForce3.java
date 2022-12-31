package programmers.bruteforce;

/**
 * 피로도
 */
public class BruteForce3 {

    int answer = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);

        return answer;
    }

    void dfs(int k, int depth, int[][] dungeons){
        if(depth >= answer){
            answer = depth;
        }

        for(int i = 0; i < dungeons.length; i++){
            int[] dungeon = dungeons[i];

            if(!visited[i] && k >= dungeon[0]){
                visited[i] = true;
                dfs(k - dungeon[1], depth + 1, dungeons);
                visited[i] = false;
            }
        }

    }
}
