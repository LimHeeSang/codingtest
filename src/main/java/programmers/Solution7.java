package programmers;

//level1-7 음양 더하기
class Solution7 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0; i<absolutes.length; i++){
            answer += signs[i] == true ? absolutes[i]:-absolutes[i];

        }


        return answer;
    }
}
