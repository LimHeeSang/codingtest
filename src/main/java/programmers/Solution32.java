package programmers;
import java.util.*;

//level1-32 문자열 내림차순으로 배치하기
class Solution32 {
    public String solution(String s) {
        String answer = "";
        String[] str = new String[s.length()];

        for(int i=0; i<s.length(); i++){
            str[i] = String.valueOf(s.charAt(i));
        }

        Arrays.sort(str, Collections.reverseOrder());

        for(String a : str){
            answer += a;
        }

        return answer;
    }
}
