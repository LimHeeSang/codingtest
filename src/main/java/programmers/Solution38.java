package programmers;

//level1-38 시저 암호
class Solution38 {
    public String solution(String s, int n) {
        String answer = "";

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            //대문자인 경우
            if(ch >= 'A' && ch <= 'Z'){
                ch = (char)('A' + (ch + n - 'A') % 26 );

            }else if(ch >= 'a' && ch <= 'z'){   //소문자인 경우
                ch = (char)('a' + (ch + n - 'a') % 26 );

            }

            answer += ch;
        }

        return answer;
    }
}
