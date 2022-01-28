package programmers.level1;

//level1-6 없는 숫자 더하기
class Solution6 {
    public int solution(int[] numbers) {
        int answer = 0;

        boolean[] check = new boolean[10];

        for(int number:numbers){
            check[number] = true;
        }

        for(int i=0; i<check.length; i++){
            if(check[i] == false){
                answer += i;
            }
        }


        return answer;
    }
}
