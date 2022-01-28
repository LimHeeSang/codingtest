package programmers.level1;

//level1-49 평균 구하기
class Solution49 {
    public double solution(int[] arr) {
        double answer = 0;

        double sum = 0;
        for(int a : arr){
            sum += a;
        }

        answer = sum / arr.length;
        return answer;
    }
}
