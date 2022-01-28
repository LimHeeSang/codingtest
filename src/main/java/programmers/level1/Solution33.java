package programmers.level1;

//level1-33 문자열 다루기 기본
class Solution33 {
    public boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();

        if(s.length()!=4 && s.length()!=6) answer = false;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                answer = false;
                break;
            }
        }

        return answer;
    }
}
