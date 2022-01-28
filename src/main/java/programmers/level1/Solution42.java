package programmers.level1;

//level1-42 자연수 뒤집어 배열로 만들기
class Solution42 {
    public int[] solution(long n) {
        int[] answer;

        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();

        answer = new int[sb.length()];
        for(int i=0; i<sb.length(); i++){
            answer[i] = Integer.parseInt(String.valueOf(sb.charAt(i)));
        }

        return answer;
    }
}