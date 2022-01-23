package programmers;
import java.util.*;

//level1-27 같은 숫자는 싫어
public class Solution27 {
    public int[] solution(int []arr) {
        int[] answer;
        List<Integer> list = new ArrayList<>();

        int preNum = -1;
        for(int a : arr){
            if(preNum == a) continue;
            list.add(a);
            preNum = a;
        }

        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) answer[i] = list.get(i);

        return answer;
    }
}
