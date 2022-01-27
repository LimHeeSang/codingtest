package programmers;

//level1-44 정수 제곱근 판별
class Solution44 {
    public long solution(long n) {
        long answer = 0;

        for(long i = 1; i <= Math.sqrt(n); i++){
            if(i*i == n){
                answer = i;
                break;
            }
        }

        if(answer == 0) return -1;

        answer = (long)Math.pow(answer+1, 2);

        return answer;
    }
}