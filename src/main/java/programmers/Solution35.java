package programmers;

//level1-35 소수 찾기
class Solution35 {
    public int solution(int n) {
        int answer = n-1;

        int count = 0;
        for(int i=2; i<=n; i++){
            for(int j=2; j<=Math.sqrt(i); j++){
                if(i%j == 0){
                    count++;
                    break;
                }
            }
        }

        answer -= count;
        return answer;
    }
}