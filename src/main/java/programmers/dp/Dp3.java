package programmers.dp;

//dp3 등굣길
class Dp3 {

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        final int MOD = 1000000007;

        int[][] map = new int[n+1][m+1];
        for(int i=0; i<puddles.length; i++){
            map[puddles[i][1]][puddles[i][0]] = -1;
        }
        map[1][1] = 1;

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(i == 1 && j == 1) continue;
                if(map[i][j] == -1) map[i][j] = 0;
                else map[i][j] = map[i][j-1] % MOD + map[i-1][j] % MOD;
            }
        }


        answer = map[n][m] % MOD;

        return answer;
    }
}
