package programmers.dp;

//dp1 N으로 표현
class Dp1 {
    int answer;

    public int solution(int N, int number) {
        answer = -1;

        dfs(N, number, 0, 0);

        return answer;
    }

    public void dfs(int n, int number, int preSum, int count){
        if(count > 8) return;

        if(preSum == number){
            if(count < answer || answer == -1) answer = count;
            return;
        }

        int tempN = 0;
        for(int i=1; i<9; i++){
            tempN = tempN * 10 + n;
            dfs(n, number, preSum + tempN, count+i);
            dfs(n, number, preSum - tempN, count+i);
            dfs(n, number, preSum * tempN, count+i);
            dfs(n, number, preSum / tempN, count+i);
        }

    }
}