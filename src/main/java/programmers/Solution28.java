package programmers;
import java.util.*;

//level1-28 나누어 떨어지는 숫자 배열
class Solution28 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;

        List<Integer> list = new ArrayList<>();

        for(int a : arr){
            if(a%divisor == 0){
                list.add(a);
            }
        }

        if(list.isEmpty()){
            answer = new int[]{-1};
            return answer;
        }else{
            answer = new int[list.size()];
        }

        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);

        Arrays.sort(answer);

        return answer;
    }
}
