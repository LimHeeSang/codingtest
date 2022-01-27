package programmers;
import java.util.*;

//level1-43 정수 내림차순으로 배치하기
class Solution43 {
    public long solution(long n) {
        long answer = 0;

        String[] str = String.valueOf(n).split("");

        Arrays.sort(str, Collections.reverseOrder());

        String temp = "";
        for(String s : str){
            temp += s;
        }
        answer = Long.parseLong(temp);


        return answer;
    }
}
