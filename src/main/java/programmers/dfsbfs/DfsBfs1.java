package programmers.dfsbfs;

//dfsbfs1 타켓 넘버
class DfsBfs1 {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(numbers, 0, 0, target);

        return answer;
    }

    public int dfs(int[] numbers, int idx, int temp, int target){
        if(idx == numbers.length){
            if(target == temp) return 1;
            return 0;
        }

        return dfs(numbers, idx+1, temp + numbers[idx], target) + dfs(numbers, idx+1, temp + numbers[idx]*(-1), target);
    }
}
