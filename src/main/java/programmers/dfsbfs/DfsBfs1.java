package programmers.dfsbfs;

//dfsbfs1 타켓 넘버
class DfsBfs1 {
    static int count = 0;

    public int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(numbers, 0, 0, target);
        answer = count;

        return answer;
    }

    public void dfs(int[] numbers, int idx, int temp, int target){
        if(idx == numbers.length){
            if(target == temp) count++;
            return;
        }


        temp += numbers[idx];
        dfs(numbers, idx+1, temp, target);

        temp -= numbers[idx];
        temp += numbers[idx]*(-1);
        dfs(numbers, idx+1, temp, target);
    }
}
