package programmers.level1;

//level1-23 부족한 금액 계산하기
class Solution23 {
    public long solution(int price, int money, int count) {
        long answer = 0;

        long result = 0;
        for(int i=1; i<=count; i++){
            result += price*i;
        }

        answer = money - result;


        return answer >= 0 ? 0 : -answer;
    }
}
