package programmers;

//level1-42 자연수 뒤집어 배열로 만들기
class Solution42 {
    public int[] solution(long n) {
        int[] answer;

        String[] str = String.valueOf(n).split("");

        answer = new int[str.length];
        for(int i = 0; i<str.length; i++){
            answer[i] = Integer.parseInt(str[str.length-i-1]);
        }

        return answer;
    }
}