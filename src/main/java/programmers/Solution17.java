package programmers;
import java.util.*;

//level1-17 3진법 뒤집기
class Solution17 {
    public int solution(int n) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        while(n != 0){
            list.add(n%3);
            n /= 3;
        }

        int j = 0;
        for(int i=list.size()-1; i>=0; i--){
            answer += Math.pow(3, j++)*list.get(i);
        }

        return answer;
    }
}
