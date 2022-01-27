package programmers;

//level1-39 약수의 합
class Solution39 {
    public int solution(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        int answer = 0;
        answer = 1 + n;

        for(int i=2; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                answer += i;
                answer += n/i;

                if(i == n/i) answer -= i;
            }
        }

        return answer;
    }
}
