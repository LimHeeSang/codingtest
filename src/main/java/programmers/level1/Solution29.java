package programmers.level1;

//level1-29 두 정수 사이의 합
class Solution29 {
    public long solution(int a, int b) {
        long answer = 0;

        if(a>b){
            int temp = a;
            a = b;
            b = temp;
        }


        for(int i=a; i<=b; i++){
            answer += i;
        }

        return answer;
    }
}
