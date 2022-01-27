package programmers;

//level1-40 이상한 문자 만들기
class Solution40 {
    public String solution(String s) {
        String answer = "";

        char[] chs = s.toCharArray();

        int idx = 0;
        for(char ch : chs){
            if(ch == ' '){
                idx = 0;
                answer += ch;
            }else if(idx++ % 2 == 0){
                answer += Character.toUpperCase(ch);
            }else{
                answer += Character.toLowerCase(ch);
            }
        }

        return answer;
    }
}
