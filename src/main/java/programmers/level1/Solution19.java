package programmers.level1;
import java.util.*;

//level1-19 두 개 뽑아서 더하기
class Solution19 {
    public int[] solution(int[] numbers) {
        int[] answer;

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }

        int i=0;
        answer = new int[set.size()];
        for(int s : set){
            answer[i++] = s;
        }

        Arrays.sort(answer);
        return answer;
    }
}
